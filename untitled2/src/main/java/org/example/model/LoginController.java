package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * @author:飞哥
 * @date: 2021/6/9 19:16
 */
@Controller
public class LoginController {
    //@Autowired
    private MyService myService;
    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
    public void sayhi(){
        myService.sayhi();
    }
    /*public void sayhi(){
            myService.sayhi();
        }*/
    @Bean
public User user(){
    User user1=new User();
    user1.setName("java");
    user1.setPassword("java");
    return user1;
}
}
