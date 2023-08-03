package com.Library.service;

import com.Library.model.Book;
import com.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(String bookName){

        return new Book(bookRepository.addBook(bookName), bookName);

    }
}
