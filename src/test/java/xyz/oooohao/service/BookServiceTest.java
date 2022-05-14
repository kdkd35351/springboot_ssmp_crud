package xyz.oooohao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.oooohao.domain.Book;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById() {
        System.out.println(bookService.getById(6));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("测试数据123");
        book.setType("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
        System.out.println(book.getId());
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(15);
        book.setName("测试数据abc");
        book.setType("测试数据abc");
        book.setDescription("测试数据abc");
        bookService.update(book);
    }

    @Test
    public void testDelete() {
        bookService.delete(15);
    }

    @Test
    public void testGetAll() {
        bookService.getAll();
    }

    @Test
    public void testGetPage() {
        IPage<Book> iPage = bookService.getPage(1, 5);
        List<Book> books = iPage.getRecords();
        books.forEach(System.out::println);
    }

}
