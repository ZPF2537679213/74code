package com.example.dao;

import com.example.demo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author:飞哥
 * @date: 2021/7/4 17:42
 */
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void addUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("孙悟空");
        userInfo.setPassWord("吃俺老孙一包");
        userInfoMapper.addUser(userInfo);
    }
}