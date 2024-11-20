package com.hmz.DbInit.dao;

import com.hmz.DbInit.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String s);
}
