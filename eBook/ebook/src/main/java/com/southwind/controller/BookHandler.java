package com.southwind.controller;

import com.southwind.entity.Book;
import com.southwind.entity.BookVO;
import com.southwind.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookService bookService;

    @GetMapping("/findByPage/{page}")
    @ApiOperation("findByPage")
    public BookVO findByPage(@PathVariable("page") Integer page){
        return bookService.findByPage(page);
    }

    @PostMapping("/save")
    @ApiOperation("save")
    public Integer save(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(("deleteById"))
    public Integer deleteById(@PathVariable("id") Integer id){
        return bookService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(("findById"))
    public Book findById(@PathVariable("id") Integer id){
        return bookService.findById(id);
    }

    @PutMapping("/update")
    @ApiOperation(("update"))
    public Integer update(@RequestBody Book book){
        return bookService.update(book);
    }
}
