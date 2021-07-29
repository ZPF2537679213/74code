package com.example.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/22 17:48
 */
@Data
public class UserInfo {
    private int id;
    private String name;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String address;
    private String qq;
    private String email;
    private int isadmin;
    private Date logintime;
    private int failcount;
}
