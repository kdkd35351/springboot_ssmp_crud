package xyz.oooohao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import xyz.oooohao.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(Integer current, Integer size);
}
