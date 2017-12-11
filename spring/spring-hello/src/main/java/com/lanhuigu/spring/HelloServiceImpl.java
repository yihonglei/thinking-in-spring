package com.lanhuigu.spring;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        System.out.println("Hello:" + name);
    }
}
