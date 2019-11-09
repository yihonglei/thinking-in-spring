package com.lanhuigu.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 注解@Configuration开启组件扫描，spring默认是关闭的;
 * 2. 注解@ComponentScan默认扫描与Application类同级包以及子包下包含@Component的类，创建为bean;
 *    这里扫描com.lanhuigu.spring包下包含@Component类创建为bean。
 * 3. 如果不想使用@ComponentScan默认扫描包，可以通过basePackages显示指定,
 *    比如: @ComponentScan(basePackages = {"com.lanhuigu.spring"})
 *    同时basePackages默认参数是数组，如果想指定多个扫描包,用逗号隔开就行。
 *    注解@ComponentScan还有另外一种方式就是通过basePackageClasses显示指定，
 *    比如: @ComponentScan(basePackageClasses = {HelloServiceImpl.class})
 *    含义就是扫描HelloServiceImpl类所在的包，也即是通过类反推出扫描包。
 */
@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        // 通过注解形式获取bean容器(从一个或多个基于Java的配置类中加载Spring应用上下文)
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        // 从容器中获取bean
        HelloService helloService = context.getBean(HelloServiceImpl.class);
        // 调用bean的方法
        helloService.sayHello("Tom");
    }
}
