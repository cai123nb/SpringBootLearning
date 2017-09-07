package com.cjyong.spring.main.controller;

import com.cjyong.spring.main.entity.User;
import com.cjyong.spring.main.entity.dto.MyJsonResult;
import com.cjyong.spring.main.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @ApiOperation(value = "根据用户名获取用户信息")
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

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/list")
    public ResponseEntity<MyJsonResult<List<User>>> getUserList(){
        MyJsonResult<List<User>> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.getUserList());
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<List<User>>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID获取用户信息")
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<MyJsonResult<User>> getUserById(@PathVariable long id){
        MyJsonResult<User> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.getUserById(id));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<User>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID更新用户信息")
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<MyJsonResult<User>> updateUserById(@PathVariable long id, @RequestBody User user){
        MyJsonResult<User> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.updateUserById(id, user));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<User>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID删除用户")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MyJsonResult<Boolean>> deleteUserById(@PathVariable long id){
        MyJsonResult<Boolean> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.deleteUserById(id));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<Boolean>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping("")
    public ResponseEntity<MyJsonResult<Boolean>> createUser(@RequestBody @Valid User user){
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
