package com.lanhuigu.datasource.c3p0;

import com.lanhuigu.datasource.dao.HelloDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试C3P0数据源
 */
public class C3P0Test {

    @Test
    public void testHello() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-c3p0.xml");
        // 从容器中获取bean
        HelloDAO helloDAO = (HelloDAO) context.getBean("helloDAO");
        // 调用插入方法
        helloDAO.insertTest();
    }

}
