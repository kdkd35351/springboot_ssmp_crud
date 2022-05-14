package xyz.oooohao.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.oooohao.domain.Book;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("测试数据123");
        book.setType("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
        System.out.println(book.getId());
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setName("测试数据abc");
        book.setType("测试数据abc");
        book.setDescription("测试数据abc");
        bookDao.updateById(book);
    }

    @Test
    public void testDelete() {
        bookDao.deleteById(14);
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookDao.selectList(null);
        books.forEach(System.out::println);
    }

    @Test
    public void testGetPage() {
        IPage<Book> page = new Page<>(1, 5);
        IPage<Book> iPage = bookDao.selectPage(page, null);
        //返回当前页记录
        List<Book> books = iPage.getRecords();
        books.forEach(System.out::println);
    }

    //测试按条件查询
    @Test
    public void testGetBy() {
        String name = null;
//        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "Java");
        //使用Lambda表达式封装查询条件对象
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name != null, Book::getName, name);
        bookDao.selectList(wrapper);
    }
}
