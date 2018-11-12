package com.lanhuigu.datasource.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 模拟DAO层
 * @author yihonglei
 * @date 2018/11/12 17:01
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

    public void insertTest() {
        String sql = "insert into t_user_main (userId, userName, age) values (1, 'DataSource', 27)";
        jdbcTemplate.update(sql);
    }
}
