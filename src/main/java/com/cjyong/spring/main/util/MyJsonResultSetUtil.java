package com.cjyong.spring.main.util;

import com.cjyong.spring.main.entity.dto.MyJsonResult;

/**
 * Created by cjyong on 2017/8/10.
 */
public final class MyJsonResultSetUtil<T> {

    private MyJsonResult<T> myJsonresult;

    public MyJsonResultSetUtil() {
        myJsonresult = new MyJsonResult<>();
        myJsonresult.setSuccess(true);
        myJsonresult.setMessage("success");
    }

    public MyJsonResult<T>  setData(T t){
        this.myJsonresult.setResult(t);
        return this.myJsonresult;
    }

    public MyJsonResult<T> setErrorMsg(String msg){
        this.myJsonresult.setSuccess(false);
        this.myJsonresult.setMessage(msg);
        return this.myJsonresult;
    }
}
