package com.lanhuigu.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于@ContextConfiguration构建Spring环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AopTest {

    @Autowired
    private ConferenceServiceImpl conferenceService;

    @Test
    public void testAopAnnotation() {
        conferenceService.conference();
    }

}
