package com.cjyong.spring.main.entity.dto;


import com.cjyong.spring.main.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    private static final UserDto EMPTY = new UserDto();

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String passwd;

    public UserDto() {}

    public static UserDto empty(){
        return EMPTY;
    }

    public UserDto(User user) {
        this();
        BeanUtils.copyProperties(user, this);
    }

    public User convertToUser() {
        User convert = new User();
        BeanUtils.copyProperties(this, convert);
        return convert;
    }
}
