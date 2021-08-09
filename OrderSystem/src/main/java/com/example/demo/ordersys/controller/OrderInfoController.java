package com.example.demo.ordersys.controller;

import com.example.demo.ordersys.mapper.OrderDetailMapper;
import com.example.demo.ordersys.mapper.OrderMapper;
import com.example.demo.ordersys.model.OrderInfo;
import com.example.demo.ordersys.model.UserInfo;
import com.example.demo.ordersys.tools.MyResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/8/7 9:53
 */
@RequestMapping("/order")
@RestController
public class OrderInfoController {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @RequestMapping("/add")
    public MyResponseBody<Integer>add(String dids, HttpServletRequest request){
        int data=0;
        HttpSession session=request.getSession(false);
        UserInfo userInfo=null;
        if(session!=null){
            userInfo=(UserInfo) session.getAttribute("userinfo");
        }else{
            return new MyResponseBody<>(-1,"用户未登录！",data);
        }
        int uid=0;
        if(userInfo!=null){
          uid=userInfo.getId();
        }
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setUid(uid);
        data=orderMapper.add(orderInfo);
        String[]did=dids.split(",");
        if(data>0){
            orderDetailMapper.add(orderInfo.getId(),did);
        }
        return new MyResponseBody<>(0,"",data);
    }
    @RequestMapping("/list")
    public MyResponseBody<List<OrderInfo>>getlist(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        UserInfo userInfo=null;
        if(session!=null){
            userInfo=(UserInfo) session.getAttribute("userinfo");
            ArrayList<OrderInfo>list=orderMapper.getlist(userInfo.getId());
            return new MyResponseBody<>(0,"",list);
        }else{
            return new MyResponseBody<>(-1,"用户未登录！",new ArrayList<>());
        }
    }
    @RequestMapping("/alllist")
    public MyResponseBody<List<OrderInfo>>getAllList(){
        ArrayList<OrderInfo>list=orderMapper.getAllList();
        return new MyResponseBody<>(0,"",list);
    }
    @RequestMapping("/changestatus")
    public MyResponseBody<Integer>changeStatus(int id,int status){
        int data=orderMapper.changeStatus(id,status);
        return new MyResponseBody<>(0,"",data);
    }
}
