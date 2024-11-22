package com.hmzzz.db_test.dao;


import com.hmzzz.db_test.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long L);
    /*
       Using Optional
       if found, it will return author back wrapped in the optional
       if not found, we will still get the optional back but empty one
     */

    List<Author> find();

    void update(long id, Author author);

    void delete(long l);
}
