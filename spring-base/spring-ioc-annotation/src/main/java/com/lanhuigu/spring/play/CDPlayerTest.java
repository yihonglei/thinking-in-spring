package com.lanhuigu.spring.play;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CDPlayerTest
 * @Package: com.lanhuigu.spring.play
 * @date 2018/7/4 22:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        if (cd != null) {
            System.out.println("not null");
        } else {
            System.out.println("null");
        }
    }
}
