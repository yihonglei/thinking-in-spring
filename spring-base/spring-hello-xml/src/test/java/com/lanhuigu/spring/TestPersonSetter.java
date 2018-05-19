package com.lanhuigu.spring;

import com.lanhuigu.spring.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试setter注入字面量
 */
public class TestPersonSetter {

    @Test
    public void testPerson() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter.xml");
        // 从容器中获取bean
        Person person
                = (Person) context.getBean("person");
        // 打印个人属性
        System.out.println(" 姓名: " + person.getName() +
                           " 性别: " + person.getSex() +
                           " 年龄: " + person.getAge() +
                           " 兴趣爱好: " + person.getHobby());
    }

}
