package com.cjyong.spring.main.service.impl;

import com.cjyong.spring.main.dao.UserRepository;
import com.cjyong.spring.main.entity.dto.UserDto;
import com.cjyong.spring.main.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by cjyong on 2017/8/10.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return Optional.ofNullable(userRepository.saveAndFlush(userDto.convertToUser()))
                .map(user -> new UserDto(user))
                .orElse(UserDto.empty());
    }

    @Override
    public UserDto getUserByNameAndPasswd(String name, String passwd) {
        return Optional.ofNullable(userRepository.findFirstByNameAndPasswd(name,passwd))
                .map(user -> new UserDto(user))
                .orElse(UserDto.empty());
    }

    @Override
    public List<UserDto> getUserList() {
        return Optional.ofNullable(userRepository.findAll())
                .map(users -> users.stream()
                    .map(user -> new UserDto(user))
                    .collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    @Override
    public UserDto getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .map(user -> new UserDto(user))
                .orElse(UserDto.empty());
    }

    @Override
    public UserDto updateUserById(long id, UserDto userDto) {
        Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow( () -> new NullPointerException("User is not exsit!") );

        userDto.setId(id);
        return Optional.ofNullable(userRepository.saveAndFlush(userDto.convertToUser()))
                .map(user -> new UserDto(user))
                .orElse(UserDto.empty());
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }
}
