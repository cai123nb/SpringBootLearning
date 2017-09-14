package com.cjyong.spring.main.service;

import com.cjyong.spring.main.entity.User;
import com.cjyong.spring.main.entity.dto.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Created by cjyong on 2017/8/10.
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param userDto
     * @return
     */
    UserDto createUser(UserDto userDto);

    /**
     * 根据用户名字和密码进行登录
     *
     * @param name
     * @param passwd
     * @return
     */
    UserDto getUserByNameAndPasswd(String name, String passwd);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<UserDto> getUserList();

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return
     */
    UserDto getUserById(long id);

    /**
     * 根据用户ID更新用户信息
     *
     * @param id
     * @param userDto
     * @return
     */
    UserDto updateUserById(long id, UserDto userDto);

    /**
     * 根据用户ID删除用户
     *
     * @param id
     * @return
     */
    void deleteUserById(long id);
}
