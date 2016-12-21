package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CPR199 on 2016-12-21.
 */
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
