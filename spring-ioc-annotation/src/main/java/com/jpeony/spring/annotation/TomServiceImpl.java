package com.jpeony.spring.annotation;

import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 */
@Service(value = "tomService")
public class TomServiceImpl implements TomService {

    @Override
    public String createName() {
        return "Tom";
    }
}
