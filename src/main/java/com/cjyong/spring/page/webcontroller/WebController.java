package com.cjyong.spring.page.webcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjyong on 2017/8/7.
 */

//@RestController
public class WebController {
    @GetMapping("/")
    public String hello(){
        return "What's up Man adfa";
    }
}
