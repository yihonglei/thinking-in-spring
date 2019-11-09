package com.lanhuigu.spring.aop;

/**
 *  切面类
 */
public class PersonAspect {

    /**
     * 开会之前--找个位置坐下
     */
    public void takeSeats() {
        System.out.println("找位置坐");
    }

    /**
     * 开会之前--手机调成静音
     */
    public void silenceCellPhones() {
        System.out.println("手机调成静音");
    }

    /**
     * 开会之后--写会议总结报告
     */
    public void summary() {
        System.out.println("写会议总结报告");
    }

}
