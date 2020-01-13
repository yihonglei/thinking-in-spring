package com.jpeony.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Driver;

/**
 * 通过FactoryBean创建bean
 *
 * @author yihonglei
 */
public class FactoryBeanTest {

    /**
     * 注入bean
     *
     * @author yihonglei
     */
    @Test
    public void testBean() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-FactoryBean.xml");
        // 从容器中获取bean
        Driver driver = (Driver) context.getBean("driver");

        /*
         * 拿到的不是DriverFactoryBean，而是MySql的Driver。
         * DriverFactoryBean只是Driver的一个包装，Spring通过getBean返回的是DriverFactoryBean中
         * getObject方法返回的实际对象Driver。
         */
        System.out.println(driver);
    }

}
