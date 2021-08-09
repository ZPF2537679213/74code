package com.example.demo.ordersys.model;

import lombok.Data;

import java.util.Date;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:47
 */
@Data
public class OrderInfo {
    private int id;
    private int uid;
    private Date createtime;
    private int status;
    private UserInfo userInfo;
}
