package xyz.oooohao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.oooohao.dao.BookDao;
import xyz.oooohao.domain.Book;
import xyz.oooohao.service.IBookService;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        String type = book.getType();
        String name = book.getName();
        String description = book.getDescription();
        wrapper.like(Strings.isNotEmpty(type), Book::getType, type)
                .like(Strings.isNotEmpty(name), Book::getName, name)
                .like(Strings.isNotEmpty(description), Book::getDescription, description);
        Page<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectPage(page, wrapper);
    }
}
