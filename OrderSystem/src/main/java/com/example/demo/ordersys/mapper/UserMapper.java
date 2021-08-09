package com.example.demo.ordersys.mapper;

import com.example.demo.ordersys.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/31 14:57
 */
@Mapper
public interface UserMapper {
    int register(UserInfo userInfo);

    List<UserInfo> getUserList();

    UserInfo login(UserInfo userInfo);
}
