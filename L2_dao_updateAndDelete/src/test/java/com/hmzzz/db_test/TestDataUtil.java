package com.hmzzz.db_test;


import com.hmzzz.db_test.domain.Author;
import com.hmzzz.db_test.domain.Book;

public class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Jack Mayan")
                .age(40)
                .build();
    }

    public static Book createBookBuild() {
        return Book.builder()
                .isbn("958-1-3421-3242-3")
                .author_id(1L)
                .title("History of Us")
                .build();
    }
}
