package com.lanhuigu.spring;

import com.lanhuigu.transaction.service.AccountService;
import com.lanhuigu.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务测试
 */
public class TransactionTest {

    @Test
    public void createUser() throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean(UserService.class);
        service.createUser("yihonglei");
    }

    @Test
    public void addAccount() throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean(AccountService.class);
        service.addAccount("yihonglei", 10000);
    }

}
