package com.jpeony.spring;

import com.jpeony.spring.annotation.AppConfig;
import com.jpeony.spring.annotation.HelloService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yihonglei
 */
public class AnnotationTest {
    @Test
    public void testAnnotation() {
        // IOC容器（传入@ComponentScan对应的注解类AppConfig）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // IOC容器（直接传入需要扫描的包路径）
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.jpeony.spring.annotation");
        // 获取bean
        HelloService helloService = (HelloService) context.getBean("helloService");

        // 调用方法
        helloService.sayHello();
    }
}
