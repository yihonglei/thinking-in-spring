package com.jpeony.spring.proxy.jdk;

/**
 * @author yihonglei
 */
public class HelloImpl implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
