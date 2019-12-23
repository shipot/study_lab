package com.zx.starter.controller.rocketmq.SyncProducer;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 21:18
 */
public class SyncConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "ConsumerGroup");
        consumer.setNamesrvAddr("172.16.1.160:9876");
        consumer.setInstanceName("Consumer");
        consumer.subscribe("study_lab_topic", "tag");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                synchronized (this){
                    System.out.println(new String(list.get(0).getBody()));
                }
                return null;
            }
        });
        consumer.start();
    }
}
