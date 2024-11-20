package com.hmz.DbInit.dao.impl;

import com.hmz.DbInit.daoImpl.BookDaoImpl;
import com.hmz.DbInit.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    public BookDaoImpl underTest;

    @Test
    public void testThatCreateBooksGenerateCorrectSql(){
        Book book = Book.builder()
                .isbn("978-1-2345-6789-0")
                .author_id(1L)
                .title("The Titanic")
                .build();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("978-1-2345-6789-0"),
                eq(1L),
                eq("The Titanic"));
    }

    @Test
    public void testForSelectingBook(){
        underTest.findOne("9-8765-4321-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("9-8765-4321-0")
        );
    }
}
