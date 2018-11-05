package com.lanhuigu.spring.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 注解@ComponentScan开启组件扫描，Spring默认是关闭的;
 *    注解@ComponentScan扫描与Application类同级包以及子包下包含@Component的类，
 *    并在Spring上下文中创建为一个bean;
 *
 * 2. 如果不想使用@ComponentScan默认扫描包，可以通过basePackages显示指定,
 *    比如: @ComponentScan(basePackages = {"com.lanhuigu.spring"})
 *    同时basePackages默认参数是数组，如果想指定多个扫描包,用逗号隔开就行。
 *    注解@ComponentScan还有另外一种方式就是通过basePackageClasses显示指定，
 *    比如: @ComponentScan(basePackageClasses = {HelloServiceImpl.class})
 *    含义就是扫描HelloServiceImpl类所在的包，也即是通过类反推出扫描包。
 */
@Configuration
@ComponentScan
public class ApplicationConfig {

}
