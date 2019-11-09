package com.lanhuigu.spring;

import com.lanhuigu.spring.factorybean.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        // 得到的是apple
        System.out.println(context.getBean("appleFactoryBean"));
        // 得到的是apple工厂
        System.out.println(context.getBean("&appleFactoryBean"));
    }
}
