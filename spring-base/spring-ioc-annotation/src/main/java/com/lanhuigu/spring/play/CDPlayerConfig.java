package com.lanhuigu.spring.play;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring组件扫描默认是不启用的，通过@ComponentScan开启组件扫描。
 * 扫描注解所在包及子包。
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {

}
