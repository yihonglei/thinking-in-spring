package com.jpeony.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Jdk代理：基于接口的代理，一定是基于接口，会生成目标对象的接口的子对象。
 * Cglib代理：基于类的代理，不需要基于接口，会生成目标对象的子对象。
 * <p>
 * 1. 注解@EnableAspectJAutoProxy开启代理;
 * <p>
 * 2. 如果属性proxyTargetClass默认为false, 表示使用jdk动态代理织入增强;
 * <p>
 * 3. 如果属性proxyTargetClass设置为true，表示使用Cglib动态代理技术织入增强;
 * <p>
 * 4. 如果属性proxyTargetClass设置为false，但是目标类没有声明接口，
 * Spring aop还是会使用Cglib动态代理，也就是说非接口的类要生成代理都用Cglib。
 *
 * @author yihonglei
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.jpeony")
public class AppConfig {


}
