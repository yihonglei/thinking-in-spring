package com.lanhuigu.transaction.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import javax.sql.DataSource;

/**
 * 模拟DAO层--简单测试
 */
public class HelloDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /**
     * setter依赖注入DataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert() {
        String sql = "insert into t_user_main (userId, userName, age) values (1, 'DataSource', 27)";
        jdbcTemplate.update(sql);
    }
}
