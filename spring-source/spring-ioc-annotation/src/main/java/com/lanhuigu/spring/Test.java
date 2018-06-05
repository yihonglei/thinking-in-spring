package com.lanhuigu.spring;

import javafx.application.Application;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @author yihonglei
 * @ClassName: Test
 * @Package: com.lanhuigu
 * @date 2018/5/22 11:47
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        BeanFactory;
        HierarchicalBeanFactory;
        ConfigurableBeanFactory;
        AutowireCapableBeanFactory;
        FactoryBean;
        XmlBeanFactory;
        DefaultListableBeanFactory;
        ApplicationContext;
        FileSystemXmlApplicationContext;
        ClassPathXmlApplicationContext;
        ConfigurableApplicationContext;
        Resource;
        ClassPathResource;
        BeanDefinition;
        BeanDefinitionReader;

        BeforeAdvice;
        MethodBeforeAdvice;
        AfterAdvice;
        ThrowsAdvice;
        AfterReturningAdvice;

        Pointcut;
        JdkRegexpMethodPointcut;
        DefaultPointcutAdvisor;
        ProxyFactoryBean;

    }
}
