package com.zx.starter.controller.rocketmq.SyncProducer;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 20:39
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroup");
        producer.setNamesrvAddr("172.16.1.160:9876;172.16.1.170:9876");
        producer.setInstanceName("Producer");
        producer.start();
        for (int i = 0; i < 10; i++) {
            String m = ":"+i;
            Message msg = new Message("study_lab_topic", "tag","OrderID1", m.getBytes());
            SendResult sendResult = producer.send(msg);
            System.out.println(Thread.currentThread().getName()+":"+sendResult.getMessageQueue());
        }
        producer.shutdown();

    }


}
