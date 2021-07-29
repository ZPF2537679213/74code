package com.example.demo.tool;

import com.example.demo.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author:飞哥
 * @date: 2021/7/24 10:31
 */
public class SessionUtil {
    public static UserInfo getUserBySession(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("userinfo")!=null){
            return (UserInfo)session.getAttribute("userinfo");
        }
        return new UserInfo();
    }
}
