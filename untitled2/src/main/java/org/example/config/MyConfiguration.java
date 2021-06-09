package org.example.config;

import org.example.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:飞哥
 * @date: 2021/6/9 19:30
 */
@Configuration
public class MyConfiguration {

    @Bean
    public User user(){
        User user1=new User();
        user1.setName("java");
        user1.setPassword("java");
        return user1;
    }
}
