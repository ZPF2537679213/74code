package com.example.demo.ordersys.mapper;

import com.example.demo.ordersys.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author:飞哥
 * @date: 2021/8/7 10:09
 */
@Mapper
public interface OrderDetailMapper  {
   int add(int oid,String[]dids);

    ArrayList<OrderDetail> getlist(int oid);
}
