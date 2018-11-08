package com.lanhuigu.spring;

import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public void conference() {
        System.out.println("开会......");
    }

}
