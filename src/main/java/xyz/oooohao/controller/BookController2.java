package xyz.oooohao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.oooohao.domain.Book;
import xyz.oooohao.service.IBookService;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll() {
        return iBookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return iBookService.modify(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(
            @PathVariable("id") Integer id
    ) {
        return iBookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getById(
            @PathVariable("id") Integer id
    ) {
        return iBookService.getById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(
            @PathVariable("currentPage") int currentPage,
            @PathVariable("pageSize") int pageSize
    ) {
        return iBookService.getPage(currentPage, pageSize);
    }

}
