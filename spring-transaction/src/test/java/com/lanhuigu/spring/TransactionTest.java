package com.lanhuigu.spring;

import com.lanhuigu.transaction.service.AccountService;
import com.lanhuigu.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务测试
 *
 * @author yihonglei
 */
public class TransactionTest {

    /**
     * 测试有无事务的效果。
     *
     * @author yihonglei
     */
    @Test
    public void addAccount() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean(AccountService.class);
        service.addAccount("yihonglei", 10000);
    }

    /**
     * 测试新开一个事务的效果。
     *
     * @author yihonglei
     */
    @Test
    public void createUser() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean(UserService.class);
        service.createUser("yihonglei");
    }

    /**
     * 演示事务失效效果。
     *
     * @author yihonglei
     */
    @Test
    public void invalidate() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean(UserService.class);
        service.a("yihonglei");
    }

}
