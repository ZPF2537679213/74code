package com.example.demo.ordersys.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:48
 */
@Data
public class Dish {
    private int id;
    private String name;
    private BigDecimal price;
}
