package com.lanhuigu.spring;

import com.lanhuigu.spring.collection.Collection;
import com.lanhuigu.spring.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试setter注入集合
 */
public class TestCollectionSetter {

    @Test
    public void testPerson() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter.xml");
        // 从容器中获取bean
         Collection collection = (Collection) context.getBean("collection");
        // 打印个人属性
        System.out.println("Setter注入集合:" + collection.toString());
    }

}
