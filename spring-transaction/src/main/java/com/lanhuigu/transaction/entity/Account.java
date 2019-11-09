package com.lanhuigu.transaction.entity;

import java.io.Serializable;

/**
 * 账户实体
 *
 * @author yihonglei
 * @date 2019/1/14 20:15
 */
public class Account implements Serializable {
    private int id;
    private String userName;
    private String accountName;
    private String money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
