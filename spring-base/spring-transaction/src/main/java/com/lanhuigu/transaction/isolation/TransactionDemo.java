package com.lanhuigu.transaction.isolation;

import com.lanhuigu.transaction.service.UserService;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 *
 * @author yihonglei
 * @date 2019/1/14 20:36
 */
public class TransactionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-tx.xml");
        final UserService userSerivce = context.getBean(UserService.class);

        UserService proxyUserSerivce = (UserService) Proxy.newProxyInstance(TransactionDemo.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            System.out.println("开启事物:"+method.getName());
                            return method.invoke(userSerivce, args);
                        } finally {
                            System.out.println("关闭事物:"+method.getName());
                        }
                    }
                });
        proxyUserSerivce.createUser("yihonglei");
//        开启事物:createUser
//        开启事物: addAccount
//        关闭事物:addAccount
//       关闭事物:createUser
    }
}
