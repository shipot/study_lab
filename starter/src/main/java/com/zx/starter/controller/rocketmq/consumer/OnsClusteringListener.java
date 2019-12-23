package com.zx.starter.controller.rocketmq.consumer;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.zx.starter.controller.rocketmq.handler.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 19:33
 */
@Component
public class OnsClusteringListener implements MessageListener {

    public static MessageHandler messageHandler;
    private static Logger logger = LoggerFactory.getLogger(OnsClusteringListener.class);

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        try {
            String password = new String(message.getBody());
            messageHandler.handler(password);
            return Action.CommitMessage;
        } catch (Exception e) {
            logger.info("sendMsgContent-Err:" + e.getMessage());
            return Action.CommitMessage;
        }
    }
}
