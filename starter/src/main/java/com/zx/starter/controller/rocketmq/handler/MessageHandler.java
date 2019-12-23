package com.zx.starter.controller.rocketmq.handler;

import org.springframework.stereotype.Component;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 19:35
 */
@Component
public class MessageHandler {

    public void handler(String password){
        System.out.println(password);
    }

}
