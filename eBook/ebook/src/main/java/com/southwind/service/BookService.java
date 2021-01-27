package com.southwind.service;

import com.southwind.entity.Book;
import com.southwind.entity.BookVO;

public interface BookService {
    public BookVO findByPage(Integer page);
    public Integer save(Book book);
    public Integer deleteById(Integer id);
    public Book findById(Integer id);
    public Integer update(Book book);
}
