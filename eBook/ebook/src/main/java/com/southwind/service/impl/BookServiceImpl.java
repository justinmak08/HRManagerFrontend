package com.southwind.service.impl;

import com.southwind.entity.Book;
import com.southwind.entity.BookVO;
import com.southwind.repository.BookRepository;
import com.southwind.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
 
    @Autowired
    private BookRepository bookRepository;
    private Integer limit = 10;

    @Override
    public BookVO findByPage(Integer page) {
        Integer index = (page-1)*limit;
        BookVO bookVO = new BookVO();
        bookVO.setData(bookRepository.find(index,limit));
        bookVO.setTotal(bookRepository.count());
        bookVO.setPageSize(limit);
        return bookVO;
    }

    @Override
    public Integer save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Integer deleteById(Integer id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Integer update(Book book) {
        return bookRepository.update(book);
    }

}
