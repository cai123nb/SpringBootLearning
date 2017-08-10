package com.cjyong.spring.main.exception;

/**
 * Created by cjyong on 2017/8/10.
 */
public class DBOpeException extends RuntimeException {

    public DBOpeException(String args){
        super("Databse Operation Exception: "+args);
    }
}
