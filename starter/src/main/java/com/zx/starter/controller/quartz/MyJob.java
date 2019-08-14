package com.zx.starter.controller.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouxiong
 * @Title: MyJob
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1411:59
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        System.out.println("MyJobA -- 时间：" + nowTime);
    }
}
