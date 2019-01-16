package com.lanhuigu.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于AnnotationConfigApplicationContext构建Spring环境
 */
public class AopTest2 {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ConferenceService conferenceService = context.getBean(ConferenceService.class);

        conferenceService.conference();
    }

}
