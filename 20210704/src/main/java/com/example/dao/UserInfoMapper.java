package com.example.dao;

import com.example.demo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author:飞哥
 * @date: 2021/7/4 17:30
 */
@Mapper
public interface UserInfoMapper {
 public int addUser(UserInfo userInfo);
}
