package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 账户
 *
 * @author yihonglei
 * @date 2019/1/14 10:21
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addAccount(String userName, int initMoney) {
        String accountName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("INSERT INTO account (accountName,userName,money) VALUES (?,?,?)", accountName, userName, initMoney);

        // 人为报错抛异常，使用事务时，事务回滚，插入失败，如果不使用事务，则插入成功。
//        int i = 1/0;
    }

}
