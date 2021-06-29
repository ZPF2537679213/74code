package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @author:飞哥
 * @date: 2021/6/27 16:47
 */
@Setter
@Getter
public class User {
  private String username;
  private String password;
}
