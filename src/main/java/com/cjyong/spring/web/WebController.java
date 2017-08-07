package com.cjyong.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjyong on 2017/8/7.
 */
@RestController
public class WebController {
    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
}
