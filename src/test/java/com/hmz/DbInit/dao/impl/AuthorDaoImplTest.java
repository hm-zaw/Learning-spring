package com.hmz.DbInit.dao.impl;

import com.hmz.DbInit.TestDataUtil;
import com.hmz.DbInit.daoImpl.AuthorDaoImpl;
import com.hmz.DbInit.domain.Author;
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
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGenerateCorrectSql(){
        Author author = createTestAuthor();
        
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L),
                eq("John McCarthy"),
                eq(34)
        );
    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("John McCarthy")
                .age(34)
                .build();
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
}
