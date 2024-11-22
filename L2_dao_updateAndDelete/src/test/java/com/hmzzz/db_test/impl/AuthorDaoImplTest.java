package com.hmzzz.db_test.impl;


import com.hmzzz.db_test.TestDataUtil;
import com.hmzzz.db_test.daoImpl.AuthorDaoImpl;
import com.hmzzz.db_test.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGenerateCorrectSql(){
        Author author = TestDataUtil.createTestAuthor();
        
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L),
                eq("John McCarthy"),
                eq(34)
        );
    }

    @Test
    public void testThatFindOneGenerateCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyAuthorCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, age, name FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateAuthor() {
        Author author = TestDataUtil.createTestAuthor();
        underTest.update(author.getId(), author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET name = ?, age = ? WHERE id = ?",
                "Jack Mayan", 40, author.getId()
        );
    }

    @Test
    public void testThatDeleteAuthor(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.delete(1L);

        verify(jdbcTemplate).update(
                "DELETE FROM authors WHERE id = ?", 1L
        );
    }
}
