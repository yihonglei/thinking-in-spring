package com.jpeony.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 */
@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {
    @Autowired
    private TomService tomService;

    @Override
    public void sayHello() {
        String nameTmp = tomService.createName();
        System.out.println("Name is " + nameTmp);
    }
}
