package com.jpeony.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Driver;
import java.sql.DriverManager;

/**
 * 通过FactoryBean创建bean，BeanFactory和FactoryBean区别:
 * https://blog.csdn.net/yhl_jxy/article/details/80991201
 *
 * @author yihonglei
 */
public class DriverFactoryBean implements FactoryBean {
    private String jdbcUrl;

    @Override
    public Object getObject() throws Exception {
        return DriverManager.getDriver(jdbcUrl);
    }

    @Override
    public Class<?> getObjectType() {
        return Driver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
