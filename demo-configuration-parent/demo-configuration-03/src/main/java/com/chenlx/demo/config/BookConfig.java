package com.chenlx.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Richard on 2017/5/11.
 */
@ConfigurationProperties(prefix = "my.book")
public class BookConfig {

    private String name;
    private String author;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
