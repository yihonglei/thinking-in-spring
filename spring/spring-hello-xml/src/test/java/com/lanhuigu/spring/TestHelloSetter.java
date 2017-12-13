package com.lanhuigu.spring;

import com.lanhuigu.spring.constructor.SelfIntroductionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试setter注入Bean
 */
public class TestHelloSetter {

    @Test
    public void testHello() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter.xml");
        // 从容器中获取bean
        SelfIntroductionService selfIntroductionService
                = (SelfIntroductionService)context.getBean("selfIntroductionService");
        // 调用自我介绍
        selfIntroductionService.selfIntroduction();
    }

}
