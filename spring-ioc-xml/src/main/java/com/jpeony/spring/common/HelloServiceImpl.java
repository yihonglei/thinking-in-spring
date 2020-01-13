package com.jpeony.spring.common;

/**
 * @author yihonglei
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello:" + name);
    }
}
