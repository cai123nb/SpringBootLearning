package com.cjyong.spring.main.controller;

import com.cjyong.spring.main.domain.User;
import com.cjyong.spring.main.domain.dto.MyJsonResult;
import com.cjyong.spring.main.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by cjyong on 2017/8/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<MyJsonResult<User>> getUserByNameAndPasswd(@RequestParam String name, @RequestParam String passwd){
        MyJsonResult<User> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.getUserByNameAndPasswd(name,passwd));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<User>>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MyJsonResult<Boolean>> getUserByNameAndPasswd(@RequestBody @Valid User user){
        MyJsonResult<Boolean> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.createUser(user));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<Boolean>>(result, HttpStatus.OK);
    }

}
