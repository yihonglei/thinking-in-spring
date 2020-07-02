package com.jpeony.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于AnnotationConfigApplicationContext构建Spring环境
 *
 * @author yihonglei
 */
public class AopTest2 {

    @Test
    public void testAop() {
        // 注解方式构建ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 从容器获取Bean
        ConferenceService conferenceService = context.getBean(ConferenceService.class);

        conferenceService.conference();
    }

    @Test
    public void testAopScan() {
        // 注解方式构建ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.jpeony");
        // 从容器获取Bean
        ConferenceService conferenceService = context.getBean(ConferenceService.class);

        conferenceService.conference();
    }

}
