package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.service.AccountService;
import com.lanhuigu.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {
    @Autowired
    AccountService accountService;
    @Autowired
    JdbcTemplate jdbcTemplate;



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
}
