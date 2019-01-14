package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.dao.AccountDAO;
import com.lanhuigu.transaction.service.AccountService;

/**
 * @author yihonglei
 * @date 2019/1/14 10:21
 */
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void createAccount() {
        accountDAO.insert();
    }

}
