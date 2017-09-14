package com.cjyong.spring.main.controller;

import com.cjyong.spring.conf.Swagger2Config;
import com.cjyong.spring.main.entity.User;
import com.cjyong.spring.main.entity.dto.MyJsonResult;
import com.cjyong.spring.main.entity.dto.UserDto;
import com.cjyong.spring.main.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
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

    @ApiOperation(value = "根据用户名密码获取用户信息")
    @GetMapping("/getByNameAndPasswd")
    public ResponseEntity<MyJsonResult<UserDto>> getUserByNameAndPasswd(@RequestParam String name, @RequestParam String passwd){
        MyJsonResult<UserDto> result = new MyJsonResult<>();
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
        return new ResponseEntity<MyJsonResult<UserDto>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "获取用户列表", authorizations = {@Authorization(value = Swagger2Config.securitySchemaOAuth2 ,scopes =
                    {@AuthorizationScope( scope = Swagger2Config.authorizationScopeGlobal, description = Swagger2Config.authorizationScopeGlobalDesc)})})
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MyJsonResult<List<UserDto>>> getUserList(){
        MyJsonResult<List<UserDto>> result = new MyJsonResult<>();
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
        return new ResponseEntity<MyJsonResult<List<UserDto>>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID获取用户信息")
    @GetMapping("/getUserById/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MyJsonResult<UserDto>> getUserById(@PathVariable long id){
        MyJsonResult<UserDto> result = new MyJsonResult<>();
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
        return new ResponseEntity<MyJsonResult<UserDto>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID更新用户信息")
    @PutMapping("/updateUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MyJsonResult<UserDto>> updateUserById(@PathVariable long id, @RequestBody UserDto UserDto){
        MyJsonResult<UserDto> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.updateUserById(id, UserDto));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<UserDto>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户ID删除用户")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MyJsonResult<Object>> deleteUserById(@PathVariable long id){
        MyJsonResult<Object> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            userService.deleteUserById(id);
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<Object>>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "userDto", value = "用户信息", required = true, dataType = "UserDto")
    @PostMapping("")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MyJsonResult<UserDto>> createUser(@RequestBody @Valid UserDto userDto){
        MyJsonResult<UserDto> result = new MyJsonResult<>();
        Boolean isSucess = true;
        String message = "";
        try{
            result.setResult(userService.createUser(userDto));
        } catch (Exception e){
            isSucess = false;
            message = e.getMessage();
        }
        result.setSuccess(isSucess);
        result.setMessage(message);
        return new ResponseEntity<MyJsonResult<UserDto>>(result, HttpStatus.OK);
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal.toString());
        return principal;
    }

    /**
     * 查询所用用户
     * @return
     */
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")  // 指定角色权限才能操作方法
    public ModelAndView listUsers(Model model) {

        List<User> list = new ArrayList<>();	// 当前所在页面数据列表
        list.add(User.of("waylau","12"));
        list.add(User.of("老卫","12"));
        model.addAttribute("title", "用户管理");
        model.addAttribute("userList", list);
        return new ModelAndView("users/list", "userModel", model);
    }

}
