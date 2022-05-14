package xyz.oooohao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.oooohao.controller.utils.R;
import xyz.oooohao.domain.Book;
import xyz.oooohao.service.IBookService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        return new R(true, iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if ("123".equals(book.getName()))
            throw new IOException();
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(iBookService.modify(book));
    }

    @DeleteMapping("/{id}")
    public R delete(
            @PathVariable("id") Integer id
    ) {
        return new R(iBookService.delete(id));
    }

    @GetMapping("/{id}")
    public R getById(
            @PathVariable("id") Integer id
    ) {
        return new R(true, iBookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(
            @PathVariable("currentPage") int currentPage,
            @PathVariable("pageSize") int pageSize,
            Book book
    ) {
//        System.out.println(book);
        IPage<Book> page = iBookService.getPage(currentPage, pageSize, book);
        //如果传入的当前页码值大于最大页码，就是用最大页码进行查询
        if (currentPage > page.getPages()) {
            page = iBookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }

}
