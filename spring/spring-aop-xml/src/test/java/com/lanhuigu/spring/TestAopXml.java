package com.lanhuigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopXml {

    @Test
    public void testAopXml() {
        // 根据配置文件创建spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取Bean
        ConferenceServiceImpl conferenceService = (ConferenceServiceImpl)context.getBean("conferenceService");
        // 调用Bean方法
        conferenceService.conference();
    }

}
