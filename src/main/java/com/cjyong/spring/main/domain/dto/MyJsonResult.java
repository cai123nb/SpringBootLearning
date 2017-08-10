package com.cjyong.spring.main.domain.dto;

import java.sql.Date;

/**
 * Created by cjyong on 2017/8/10.
 */
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
