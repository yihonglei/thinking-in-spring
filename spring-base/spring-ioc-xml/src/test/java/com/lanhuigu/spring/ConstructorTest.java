package com.lanhuigu.spring;

import com.lanhuigu.spring.constructor.SelfIntroductionService;
import com.lanhuigu.spring.entity.PersonConstructor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试构造器注入（bean、字面量）
 */
public class ConstructorTest {

    /**
     * 造器注入Bean
     *
     * @author yihonglei
     * @date 2018/11/5 19:42
     */
    @Test
    public void testBean() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Constructor-Bean.xml");
        // 从容器中获取bean
        SelfIntroductionService selfIntroductionService
                = (SelfIntroductionService) context.getBean("selfIntroductionService");
        // 调用自我介绍
        selfIntroductionService.selfIntroduction();
    }

    /**
     * 造器注入常量
     *
     * @author yihonglei
     * @date 2018/11/5 19:42
     */
    @Test
    public void testList() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Constructor-Constant.xml");
        // 从容器中获取bean
        PersonConstructor person = (PersonConstructor) context.getBean("personConstructor");
        // 打印个人属性
        System.out.println(" 姓名: " + person.getName() +
                " 性别: " + person.getSex() +
                " 年龄: " + person.getAge() +
                " 兴趣爱好: " + person.getHobby());
    }

}
