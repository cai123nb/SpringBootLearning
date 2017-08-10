package com.cjyong.spring.main.exception;

/**
 * Created by cjyong on 2017/8/10.
 */
public class ControllerException extends RuntimeException {
    public ControllerException(String args){
        super("Controller Operation Exception: "+args);
    }
}
