package com.lanhuigu.transaction.service.impl;

import com.lanhuigu.transaction.dao.HelloDAO;
import com.lanhuigu.transaction.service.BaseService;

public class BaseServiceImpl implements BaseService {
    private HelloDAO helloDAO;

    public void setHelloDAO(HelloDAO helloDAO) {
        this.helloDAO = helloDAO;
    }

    @Override
    public void insert(boolean flag) {
        helloDAO.insert();
    }
}
