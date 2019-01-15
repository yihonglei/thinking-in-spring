package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.service.AccountService;
import com.lanhuigu.transaction.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户
 *
 * @author yihonglei
 * @date 2019/1/15 14:37
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AccountService accountService;
    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * 事务情况：
     * 1）createUser方法开启事务，插入用户。
     * 2）addAccount方法新开一个事务(Propagation.REQUIRES_NEW)，然后抛异常。
     * <p>
     * 执行效果：
     * 插入用户会失败，添加账户成功，因为addAccount是一个新事务，不受createUser事务控制。
     *
     * @author yihonglei
     * @date 2019/1/15 11:30
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(String userName) {
        // 插入user 记录
        jdbcTemplate.update("INSERT INTO `user` (userName) VALUES(?)", userName);
        // 调用 accountService 添加帐户
        accountService.addAccount(userName, 10000);
        // 人为报错
        int i = 1 / 0;
    }

    /**
     * 使用事务非常容易犯以下错误：
     * 1）在同一个类中，a调用b，在b上面加了事务，以为b上的事务生效了，其实是不生效的，
     * 因为事务基于aop实现，是通过代理对象完成事务包裹的，必须通过代理对象调用，事务才会生效，
     * 同一个类中，a调b，相当于this.a，只是一个普通对象调用，没有事务，很多人容易犯这个错误，
     * 老坑了。
     * 2）事务方法必须为public的，否则事务也不会生效。
     *
     * @author yihonglei
     * @date 2019/1/15 11:53
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void a(String userName) {
        // 插入user 记录
        jdbcTemplate.update("INSERT INTO `user` (userName) VALUES(?)", userName);

        // 事务未生效：同类中a直接调用b方法，相当于b的代码直接写在a里面，因为a上面没有事务，所以压根就没有事务。
//         b(userName, 10000);

        // 事务生效：获取代理对象，基于代理对象调用，事务才能生效。
        UserService proxy = (UserService) AopContext.currentProxy();
        proxy.b(userName, 10000);

        // 人为报错
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void b(String userName, int initMoney) {
        // 插入account记录
        String accountName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert INTO account (accountName,userName,money) VALUES (?,?,?)", accountName, userName, initMoney);
    }
}
