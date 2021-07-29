package com.example.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:飞哥
 * @date: 2021/7/22 20:31
 */
@ControllerAdvice
public class MyControllerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ConcurrentHashMap<String,Object>map=new ConcurrentHashMap<>();
        map.put("status",200);
        map.put("data",o);
        map.put("msg","");
        return map;
    }
}
