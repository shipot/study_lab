package com.zx.starter.controller.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author zhouxiong
 * @Title: QuartzTest
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1413:38
 */
public class QuartzTest {


    @Test
    public static void main(String[] args) {
        try {
            // 构建Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 构建JobDetail
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    .withIdentity("MyJob", "myGroup")
                    .build();

            // 构建SimpleTrigger
            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger","myGroup")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail, simpleTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
