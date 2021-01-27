package com.southwind.repository;

import com.southwind.entity.BookCase;

public interface BookCaseRepository {
    public BookCase findById(Integer id);
}
