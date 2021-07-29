package com.example.demo.tool;

import lombok.Data;

/**
 * @author:飞哥
 * @date: 2021/7/24 9:22
 */
@Data
public class MyResponseBody<T> {
    private int status;
    private String message;
    private T data;
    public MyResponseBody(int status, String message, T data){
        this.status=status;
        this.message=message;
        this.data=data;
    }
}
