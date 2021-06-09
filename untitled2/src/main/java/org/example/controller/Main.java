package org.example.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:飞哥
 * @date: 2021/6/7 21:39
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        URLController controller=(URLController)context.getBean("URLController");
        URLController controller1=context.getBean(URLController.class);
        System.out.println(controller==controller1);
    }
}
