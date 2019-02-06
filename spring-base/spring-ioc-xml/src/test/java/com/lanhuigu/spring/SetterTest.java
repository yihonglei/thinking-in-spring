package com.lanhuigu.spring;

import com.lanhuigu.spring.entity.Collection;
import com.lanhuigu.spring.entity.PersonSetter;
import com.lanhuigu.spring.setter.SelfIntroductionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试setter注入(bean、字面量、集合)
 */
public class SetterTest {

    /**
     * 注入bean
     *
     * @author yihonglei
     * @date 2018/11/5 19:38
     */
    @Test
    public void testBean() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter-Bean.xml");
        // 从容器中获取bean
        SelfIntroductionService selfIntroductionService
                = (SelfIntroductionService) context.getBean("selfIntroductionService");
        // 调用自我介绍
        selfIntroductionService.selfIntroduction();
    }

    /**
     * 注入字面量
     *
     * @author yihonglei
     * @date 2018/11/5 19:38
     */
    @Test
    public void testConstant() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter-Constant.xml");
        // 从容器中获取bean
        PersonSetter person = (PersonSetter) context.getBean("personSetter");
        // 打印个人属性
        System.out.println(" 姓名: " + person.getName() +
                " 性别: " + person.getSex() +
                " 年龄: " + person.getAge() +
                " 兴趣爱好: " + person.getHobby());
    }

    /**
     * 注入集合
     *
     * @author yihonglei
     * @date 2018/11/5 19:38
     */
    @Test
    public void testList() {
        // 根据spring配置文件创建应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-Setter-List.xml");
        // 从容器中获取bean
        Collection collection = (Collection) context.getBean("collection");
        // 打印个人属性
        System.out.println("Setter注入集合:" + collection.toString());
    }

}
