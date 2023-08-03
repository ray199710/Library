package com.Library.controller;

import com.Library.model.Book;
import com.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
   @Autowired
    BookService bookService;

    @GetMapping("/addBook/{bookName}")
    @ResponseBody
    public Book addBook(@PathVariable String bookName){
        return bookService.addBook(bookName);
    }

}
