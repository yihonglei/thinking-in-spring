package com.lanhuigu.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 注解@Configuration开启组件扫描，spring默认是关闭的;
 * 注解@ComponentScan扫描与Application类同级包以及子包下包含@Component的类，创建为bean;
 * 这里扫描com.lanhuigu.spring包下包含@Component类创建为bean。
 */
@Configuration
@ComponentScan
public class ApplicationConfig {

}
