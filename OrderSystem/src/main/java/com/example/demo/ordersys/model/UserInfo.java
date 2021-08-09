package com.example.demo.ordersys.model;

import lombok.Data;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:47
 */
@Data
public class UserInfo {
private int id;
private String username;
private String password;
private int isadmin;
}
