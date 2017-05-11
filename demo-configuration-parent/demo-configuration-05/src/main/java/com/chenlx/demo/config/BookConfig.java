package com.chenlx.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Richard on 2017/5/11.
 */
@Configuration
@ConfigurationProperties(prefix = "my.book")
@PropertySource(value = "my.book.yml", encoding = "UTF-8")
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
