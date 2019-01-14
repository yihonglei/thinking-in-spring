package com.lanhuigu.transaction.service;

import com.lanhuigu.transaction.entity.Account;

import java.util.List;

public interface AccountService {

    void addAccount(String userName, int initMenoy);

    List<Account> queryAccount(String userName);

    int updateAccount(String userName, int money);

}
