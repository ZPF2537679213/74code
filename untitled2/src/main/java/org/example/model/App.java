package org.example.model;

import org.example.config.MyConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:飞哥
 * @date: 2021/6/9 19:19
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        LoginController loginController=context.getBean(LoginController.class);
        loginController.sayhi();
    }
}
