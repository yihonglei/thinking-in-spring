package com.lanhuigu.spring.proxy.compare;

/**
 * 代理模式[[ 客户端--》代理对象--》目标对象 ]]
 */
public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("**********************CGLibProxy**********************");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManager userManager = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
        userManager.addUser("lanhuigu", "123456");

        System.out.println("**********************JDKProxy**********************");
        JDKProxy jdkPrpxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("lanhuigu", "123456");
    }
}
