package com.example.demo.ordersys.model;

import lombok.Data;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:50
 */
@Data
public class OrderDetail {
    private int did;
    private int oid;
    private Dish dish;
}
