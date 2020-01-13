package com.jpeony.spring.aop;

/**
 * @author yihonglei
 */
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public void conference() {
        System.out.println("开会......");
    }

}
