package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.dao.AccountDAO;
import com.lanhuigu.transaction.dao.UserDAO;
import com.lanhuigu.transaction.service.AccountService;
import com.lanhuigu.transaction.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private AccountService accountService;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void createUser() {
        userDAO.insert();

        accountService.createAccount();
    }
}
