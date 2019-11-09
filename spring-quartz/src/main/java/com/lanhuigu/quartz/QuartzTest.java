package com.lanhuigu.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: QuartzTest
 * @Package: com.lanhuigu.quartz
 * @date 2018/7/2 14:29
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            // 创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 定义一个Trigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") // 定义name/group
                    .startNow() // 一旦加入scheduler，立即生效
                    .withSchedule(simpleSchedule() // 使用SimpleTrigger
                    .withIntervalInSeconds(1) // 每隔一秒执行一次
                    .repeatForever()) // 一直执行，奔腾到老不停歇
                    .build();

            // 定义一个JobDetail
            JobDetail job = newJob(HelloQuartz.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                    .withIdentity("job1", "group1") // 定义name/group
                    .usingJobData("name", "quartz") // 定义属性
                    .build();

            // 加入这个调度
            scheduler.scheduleJob(job, trigger);

            // 启动
            scheduler.start();

            // 运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
