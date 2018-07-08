package com.lanhuigu.spring.dbcp;

import com.lanhuigu.transaction.service.BaseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试DBCP数据源
 */
public class DBCPTest {

    @Test
    public void testHello() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-DBCP.xml");
        // 从容器中获取bean
        BaseService baseService = (BaseService) context.getBean("baseService");
        // 调用插入方法
        baseService.insert(true);
    }

}
