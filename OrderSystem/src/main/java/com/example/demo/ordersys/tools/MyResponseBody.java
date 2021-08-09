package com.example.demo.ordersys.tools;

import lombok.Data;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:54
 */
@Data
public class MyResponseBody<T>{
    private int status;
    private String msg;
    private T data;
    public MyResponseBody(int status, String msg, T data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
}
