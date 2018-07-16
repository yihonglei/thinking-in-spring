package com.lanhuigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAop() {
        // 根据配置文件创建IOC容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        // 从容器中获取Bean
        ConferenceService conferenceService = (ConferenceService) context.getBean("aopMethod");
        // 调用Bean方法
        conferenceService.conference();
    }

}
