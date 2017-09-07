package com.cjyong.spring.main.service;

import com.cjyong.spring.main.entity.User;

import java.util.List;

/**
 * Created by cjyong on 2017/8/10.
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    boolean createUser(User user);

    /**
     * 根据用户名字和密码进行登录
     *
     * @param name
     * @param passwd
     * @return
     */
    User getUserByNameAndPasswd(String name,String passwd);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 根据用户ID更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    User updateUserById(long id, User user);

    /**
     * 根据用户ID删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUserById(long id);
}
