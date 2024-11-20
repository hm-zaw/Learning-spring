package com.hmz.DbInit.dao;

import com.hmz.DbInit.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long L);
    /*
       Using Optional
       if found, it will return author back wrapped in the optional
       if not found, we will still get the optional back but empty one
     */
}
