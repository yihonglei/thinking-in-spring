package com.lanhuigu.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class LoggerAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("系统日志："+(new Date())+":"+"调用了"+method.getName()+" :使用了参数"+(Arrays.toString(args)));
    }
}
