package com.jpeony.spring;

import com.jpeony.spring.factorybean.AppleFactoryBean;
import com.jpeony.spring.factorybean.AppConfiguration;
import com.jpeony.spring.factorybean.AppleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        // 得到的是apple
        System.out.println(context.getBean("appleFactoryBean"));
        // 得到的是apple工厂
        System.out.println(context.getBean("&appleFactoryBean"));

        //
        AppleFactoryBean factoryBean = (AppleFactoryBean)context.getBean("&appleFactoryBean");
        //
        AppleBean object = (AppleBean) factoryBean.getObject();
        object.setAge(2);

        //
        AppleBean object2 = (AppleBean) factoryBean.getObject();
        System.out.println(object2);
    }
}
