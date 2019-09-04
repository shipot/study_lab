package com.zx.starter.controller.aspect;

import com.zx.domain.po.users.Users;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/29 10:21
 */
@Slf4j
@Aspect
@Component
public class TeatAop {

    @Pointcut("@annotation(com.zx.starter.controller.aspect.AspectTest)")
    public void testPointCut(){

    }

    @After("testPointCut()")
    public void around(JoinPoint joinPoint) throws Throwable{
        log.info("Aop测试");
        System.out.println("***************************");
        System.out.println("aop");
    }
}
