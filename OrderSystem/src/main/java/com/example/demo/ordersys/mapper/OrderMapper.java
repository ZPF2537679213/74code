package com.example.demo.ordersys.mapper;

import com.example.demo.ordersys.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author:飞哥
 * @date: 2021/8/7 10:00
 */
@Mapper
public interface OrderMapper {

    int add(OrderInfo orderInfo);
    ArrayList<OrderInfo> getlist(int uid);

    ArrayList<OrderInfo> getAllList();

    int changeStatus(int id, int status);
}
