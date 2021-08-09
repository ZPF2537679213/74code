package com.example.demo.ordersys.mapper;

import com.example.demo.ordersys.model.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/31 17:27
 */
@Mapper
public interface DishMapper {

    List<Dish> getlist();

    int del(int id);

    int add(String name, BigDecimal price);
}
