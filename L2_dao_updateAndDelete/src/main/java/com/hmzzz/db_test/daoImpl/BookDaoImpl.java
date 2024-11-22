package com.hmzzz.db_test.daoImpl;

import com.hmzzz.db_test.dao.BookDao;
import com.hmzzz.db_test.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)",
                book.getIsbn(), book.getTitle(), book.getAuthor_id());
    }

    @Override
    public Optional<Book> findOne(String s) {
        List<Book> result = jdbcTemplate.query(
                "SELECT isbn, author_id, title FROM books WHERE isbn=? LIMIT 1",
                new BookRowMapper(), s
        );
        return result.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .author_id(rs.getLong("author_id"))
                    .title(rs.getString("title"))
                    .isbn(rs.getString("isbn"))
                    .build();
        }
    }
}
