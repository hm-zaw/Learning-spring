package com.hmz.DbInit;

import com.hmz.DbInit.domain.Author;

public class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("John McCarthy")
                .age(34)
                .build();
    }
}
