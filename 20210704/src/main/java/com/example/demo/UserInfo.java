package com.example.demo;

import lombok.Data;

import java.util.Date;

/**
 * @author:飞哥
 * @date: 2021/7/4 17:24
 */
@Data
public class UserInfo {
    private int id;
    private String userName;
    private String passWord;
    private String photo;
    private Date upDate;
    private Date createDate;
    private int state;
}
