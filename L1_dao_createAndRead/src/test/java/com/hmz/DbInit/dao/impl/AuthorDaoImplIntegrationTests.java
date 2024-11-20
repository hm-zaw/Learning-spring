package com.hmz.DbInit.dao.impl;

import com.hmz.DbInit.TestDataUtil;
import com.hmz.DbInit.daoImpl.AuthorDaoImpl;
import com.hmz.DbInit.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImplIntegrationTests {

    @Autowired
    private AuthorDaoImpl underTest;

    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
    }
}
