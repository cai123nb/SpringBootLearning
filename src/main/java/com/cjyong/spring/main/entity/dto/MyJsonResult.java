package com.cjyong.spring.main.entity.dto;

import lombok.Data;

import java.sql.Date;

/**
 * Created by cjyong on 2017/8/10.
 */
@Data
public class MyJsonResult<T> {
    /**
     * 成功标志
     */
    private boolean success;
    /**
     * 失败消息
     */
    private String message;
    /**
     * 时间撮
     */
    private Date date = new Date(System.currentTimeMillis());

    /**
     * 结果对象
     */
    private T result;

}
