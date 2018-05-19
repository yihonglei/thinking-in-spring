package com.lanhuigu.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注意:
 *   测试该类时，注释掉ConcertConfig类和TestAopAnnotation类。
 */
public class TestAopXml {

    @Test
    public void testAopXml() {
        // 根据配置文件创建spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
         * 从容器中获取Bean：
         * 可以看到在xml中没有配置ConferenceService或ConferenceServiceImpl的内容，
         * 为什么读取applicationContext.xml配置文件创建spring容器后根据Bean ID "conferenceServiceImpl"
         * 从容器中获取ConferenceServiceImpl对象?
         * 因为在xml配置中<context:component-scan base-package="com.lanhuigu.*"/>
         * 会扫描所有带有spring注解的类，并纳入到spring容器，而@Component注解注册的Bean ID默认
         * 为类首字母小写作为Bean ID，所以ConferenceServiceImpl类在spring容器中的ID为conferenceServiceImpl。
         * 从而可以根据Bean ID从容器获取bean对象使用。
         */
        ConferenceServiceImpl conferenceService = (ConferenceServiceImpl)context.getBean("conferenceServiceImpl");
        // 调用Bean方法
        conferenceService.conference();
    }

}
