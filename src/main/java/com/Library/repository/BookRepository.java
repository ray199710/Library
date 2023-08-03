package com.Library.repository;

import com.Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addBook(String bookName){
        System.out.println("EXCUTE INSERT Book");
//        jdbcTemplate.update("INSERT INTO book(book_name) VALUES (?)", book.getBookName());
        final String SQL = "INSERT INTO book(book_name) VALUES (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bookName);

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

}
