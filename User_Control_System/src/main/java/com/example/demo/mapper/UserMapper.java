package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.UserInfo;

import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/22 17:51
 */
@Mapper
public interface UserMapper {
    UserInfo login(String username, String password);
    int updateLoginTime(int id);
    int updateFailCount(String username,int count);
    int getCountByUsername(String username);
    UserInfo getUserByUsername(String username);
    int add(UserInfo userInfo);

    UserInfo getUser(int id);

    int update(UserInfo userInfo);

    List<UserInfo> getListByPage(String name, String address, String email, int skipCount, int psize,Integer isadmin);
    int getCount(String name, String address, String email,Integer isadmin);

    int del(int id, Integer isadmin);

    Integer del2(String[]ids);
}
