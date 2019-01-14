package com.lanhuigu.spring;

import com.lanhuigu.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务测试
 */
public class TransactionTest {

    @Test
    public void testHello() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取bean
        UserService userService = (UserService) context.getBean("userService");
        // 创建用户
        userService.createUser();
    }

}
