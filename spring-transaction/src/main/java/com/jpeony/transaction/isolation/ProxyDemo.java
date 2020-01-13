package com.jpeony.transaction.isolation;

import com.jpeony.transaction.service.UserService;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * 动态代理事务模拟
 *
 * @author yihonglei
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        final UserService userSerivce = context.getBean(UserService.class);

        UserService proxyUserSerivce = (UserService) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            System.out.println("开启事物:" + method.getName());
                            return method.invoke(userSerivce, args);
                        } finally {
                            System.out.println("关闭事物:" + method.getName());
                        }
                    }
                });
        proxyUserSerivce.createUser("yihonglei");
    }
}
