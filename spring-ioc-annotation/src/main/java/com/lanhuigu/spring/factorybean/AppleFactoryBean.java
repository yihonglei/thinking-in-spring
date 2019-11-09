package com.lanhuigu.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class AppleFactoryBean implements FactoryBean{

    @Override
    public Object getObject() throws Exception {
        return new AppleBean();
    }

    @Override
    public Class<?> getObjectType() {
        return AppleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
