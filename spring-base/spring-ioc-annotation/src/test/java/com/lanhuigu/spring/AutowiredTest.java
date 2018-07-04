package com.lanhuigu.spring;

import com.lanhuigu.spring.hello.ApplicationConfig;
import com.lanhuigu.spring.hello.HappyNewYear;
import com.lanhuigu.spring.hello.HelloServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AutowiredTest {
    @Autowired
    private HappyNewYear happyNewYear;
    @Autowired
    private HelloServiceImpl helloService;

    /**
     * 通过断言测试happyNewYear是否被注入到spring容器中。
     * 如果不为空，说明自动装配成功。
     */
    @Test
    public void testHappyNewYear() {
        Assert.assertNotNull(happyNewYear);
    }

    /**
     * 调用HelloServiceImpl类中的testAutowired，
     * 而testAutowired方法中通过HappyNewYear类调用
     * 其sayHappyNewYear方法。
     */
    @Test
    public void testAutowired() {
        helloService.testAutowired();
    }
}
