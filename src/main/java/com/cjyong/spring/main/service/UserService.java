package com.cjyong.spring.main.service;

import com.cjyong.spring.main.domain.User;

/**
 * Created by cjyong on 2017/8/10.
 */
public interface UserService {

    boolean createUser(User user);

    User getUserByNameAndPasswd(String name,String passwd);
}
