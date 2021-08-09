package com.example.demo.ordersys.controller;

import com.example.demo.ordersys.mapper.UserMapper;
import com.example.demo.ordersys.model.UserInfo;
import com.example.demo.ordersys.tools.MyResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:52
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/reg")
    public MyResponseBody<Integer>register(UserInfo userInfo){
        int data=userMapper.register(userInfo);
        return new MyResponseBody<>(0,"",data);
    }
    @RequestMapping("/userlist")
    public MyResponseBody<List<UserInfo>>getUserList(){
        List<UserInfo>data;
        data=userMapper.getUserList();
        return new MyResponseBody<>(0,"",data);
    }
    @RequestMapping("/login")
    public MyResponseBody<UserInfo>login(UserInfo userInfo, HttpServletRequest request){
        userInfo=userMapper.login(userInfo);
        if(userInfo!=null&&userInfo.getId()>0){
            HttpSession session=request.getSession();
            session.setAttribute("userinfo",userInfo);
        }
        return new MyResponseBody<>(0,"",userInfo);
    }
    @RequestMapping("/isLogin")
    public MyResponseBody<UserInfo> isLogin(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        UserInfo userInfo=null;
        if(session!=null){
            userInfo=(UserInfo) session.getAttribute("userinfo");
        }
        return new MyResponseBody<>(0,"",userInfo);
    }
    @RequestMapping("/loginout")
    public MyResponseBody<Integer> loginout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("userinfo")!=null){
            session.removeAttribute("userinfo");
            return new MyResponseBody<>(0,"",1);
        }
        return new MyResponseBody<>(0,"",0);
    }
}
