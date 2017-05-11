package com.chenlx.demo.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Richard on 2017/5/5.
 */
@RestController
public class UserController {

    @Value("${my.user.name}")
    private String name;

    @GetMapping("/user/name")
    public String getUserName() {
        return name;
    }
}
