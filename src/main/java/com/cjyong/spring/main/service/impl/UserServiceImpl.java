package com.cjyong.spring.main.service.impl;

import com.cjyong.spring.main.dao.UserRepository;
import com.cjyong.spring.main.entity.User;
import com.cjyong.spring.main.exception.DBOpeException;
import com.cjyong.spring.main.service.UserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cjyong on 2017/8/10.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(User user) {
        if(null == user.getName()){
            throw new IllegalArgumentException("name is null");
        }
        if(null == user.getPasswd()){
            throw new IllegalArgumentException("password is null");
        }
        try{
            userRepository.saveAndFlush(user);
        } catch (Exception e){
            throw new DBOpeException(" user insert error!");
        }
        return true;
    }

    @Override
    public User getUserByNameAndPasswd(String name, String passwd) {
        return userRepository.findFirstByNameAndPasswd(name,passwd)
                .orElse(null);
    }

    @Override
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User updateUserById(long id, User user) {
        User oldUser = userRepository.findOne(id);
        if(oldUser == null){
            throw new NullPointerException("User is not exsited!");
        }
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean deleteUserById(long id) {
        try {
            userRepository.delete(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
