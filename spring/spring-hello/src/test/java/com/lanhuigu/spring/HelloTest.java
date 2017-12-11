package com.lanhuigu.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 1. SpringJUnit4ClassRunner测试启动时，自动创建spring应用上下文；
 * 2. 注解@ContextConfiguration会告诉它需要在ApplicationConfig加载配置；
 * 3. 而在ApplicationConfig类中包含@Configuration，@ComponentScan，
 *    则注解@Configuration开启组件扫描，spring默认是关闭的;
 *    注解@ComponentScan默认扫描与Application类同级包以及子包下包含@Component的类，创建为bean;
 *    这里扫描com.lanhuigu.spring包下包含@Component类创建为bean。
 * 4. 如果不想使用@ComponentScan默认扫描包，可以通过basePackages显示指定,
 *    比如: @ComponentScan(basePackages = "com.lanhuigu.spring")
 * 5. 默认创建bean的ID为注解@Component对应类首字母小写，比如:
 *    @Component
 *    public class HelloServiceImpl implements HelloService{
 *       ......
 *    }
 *    创建的bean的ID为helloServiceImpl,如果我们想要替换，可以显示指定，比如:
 *    @Component("helloService")
 *    public class HelloServiceImpl implements HelloService{
 *       ......
 *    }
 *    创建出来的bean的ID就为helloService。
 * 6. spring除了@Component指定创建bean外，也可以用@Named替代，大部分情况下两者
 *    是可以互换的，但是一般建议用@Component，直观而且大家都能看懂。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class HelloTest {
    @Autowired
    private HelloServiceImpl helloService;

    @Test
    public void testHello() {
        helloService.sayHello("Tom");
    }
}
