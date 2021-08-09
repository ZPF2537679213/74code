package com.example.demo.ordersys.controller;

import com.example.demo.ordersys.mapper.OrderDetailMapper;
import com.example.demo.ordersys.model.OrderDetail;
import com.example.demo.ordersys.tools.MyResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/8/7 21:23
 */
@RequestMapping("/orderdetail")
@RestController
public class OrderDetailController {
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @RequestMapping("/list")
    public MyResponseBody<List<OrderDetail>>getlist(int oid){
       ArrayList<OrderDetail> list=orderDetailMapper.getlist(oid);
       return new MyResponseBody<>(0,"",list);
    }
}
