package com.chenlx.demo.web.controller;

import com.chenlx.demo.config.BookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Richard on 2017/5/5.
 */
@RestController
public class BookController {

    @Autowired
    private BookConfig bookConfig;

    @GetMapping("/book")
    public String getBook() {
        return bookConfig.getAuthor() + " " + bookConfig.getName() + "" + bookConfig.getPrice();
    }
}
