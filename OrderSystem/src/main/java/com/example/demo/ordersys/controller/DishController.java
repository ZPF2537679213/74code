package com.example.demo.ordersys.controller;

import com.example.demo.ordersys.mapper.DishMapper;
import com.example.demo.ordersys.model.Dish;
import com.example.demo.ordersys.model.UserInfo;
import com.example.demo.ordersys.tools.MyResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/31 17:24
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Resource
    private DishMapper dishMapper;
    @RequestMapping("/list")
    public MyResponseBody<List<Dish>>getList(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        List<Dish>data=new ArrayList<>();
        if(session!=null){
            UserInfo userInfo=(UserInfo) session.getAttribute("userinfo");
            if(userInfo!=null){
                data=dishMapper.getlist();
            }
        }else{
            return new MyResponseBody<>(-1,"用户未登录！",data);
        }
        return new MyResponseBody<>(0,"",data);
    }
    @RequestMapping("/delList")
    public MyResponseBody<Integer>delDish(int id){
        int data=dishMapper.del(id);
        return new MyResponseBody<>(0,"",data);
    }
    @RequestMapping("/add")
    public MyResponseBody<Integer>add(String name, BigDecimal price){
        int data=dishMapper.add(name,price);
        return new MyResponseBody<>(0,"",data);
    }
}
