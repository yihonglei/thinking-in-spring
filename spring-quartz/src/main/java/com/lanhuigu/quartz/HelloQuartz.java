package com.lanhuigu.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: HelloQuartz
 * @Package: com.lanhuigu.quartz
 * @date 2018/7/2 14:30
 */
public class HelloQuartz implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        System.out.println("say hello to " + name + " at " + new Date());
    }
}
