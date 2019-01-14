package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.entity.Account;
import com.lanhuigu.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yihonglei
 * @date 2019/1/14 10:21
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addAccount(String userName, int initMoney) {
        String accountid = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert INTO account (accountName,userName,money) VALUES (?,?,?)", accountid, userName, initMoney);
    }

    @Override
    @Transactional
    public List<Account> queryAccount(String userName) {
        List<Account> list = jdbcTemplate.queryForList("SELECT * from account where userName=?", Account.class, userName);
        Arrays.toString(list.toArray());
        return list;
    }

    @Override
    @Transactional
    public int updateAccount(String userName, int money) {
        return jdbcTemplate.update("SELECT * from account set money=money+? where userName=?", money, userName);
    }

}
