package com.ym.smartweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qushutao
 * @since 2025/8/31 9:48
 **/
@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @GetMapping("")
    public String hello() {
        return "hello world";
    }
}
