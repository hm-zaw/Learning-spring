package com.hmzzz.db_test.dao;


import com.hmzzz.db_test.domain.Book;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String s);
}
