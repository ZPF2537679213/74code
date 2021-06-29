package com.example.demo.controller;

import com.example.demo.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author:飞哥
 * @date: 2021/6/27 13:10
 */
@Controller
@RequestMapping("/mvc")
@Slf4j
public class MyController {
    @RequestMapping("/sayhai")
    @ResponseBody
    public String getIndex(){
       log.trace("啦啦啦啦啦trace");
       log.error("啦啦啦啦啦error");
       return "<h1>hello SpringMVC</h1>";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String MyLogin(User user, HttpServletRequest request) throws JsonProcessingException {
        int status=-1;
        String msg="";
        HashMap<String,Object>map=new HashMap<>();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if(user.getUsername().equals("root")&&user.getPassword().equals("root")){
             HttpSession session=request.getSession();
             session.setAttribute("user",user);
             status=1;
        }else{
            msg="账号或密码错误";
        }
        map.put("status",status);
        map.put("msg",msg);
        ObjectMapper mapper=new ObjectMapper();
        String end=mapper.writeValueAsString(map);
        return end;
    }
}
