package com.zx.common.rocketmq;

import com.aliyun.openservices.ons.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 11:18
 */
@Configuration
public class OnsConfig {

    @Value("${aliyun.ons.onsAddr:}")
    public String onsAddr;

    @Value("${aliyun.ons.producerGroupId:}")
    public String producerGroupId;

    /**
     * 获取消息的 Producer
     *
     * @return 生产者
     */
    public Producer getProducer() {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.GROUP_ID, producerGroupId);
        properties.put(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        properties.put(PropertyKeyConst.NAMESRV_ADDR, onsAddr);
        Producer producer = ONSFactory.createProducer(properties);
        producer.start();
        return producer;
    }

    /**
     * 获取集群消费者
     * 当使用集群消费模式时，消息队列 RocketMQ 认为任意一条消息只需要被集群内的任意一个消费者处理即可。
     *
     * @return consumer
     */
    public Consumer getClusteringConsumer(String groupId) {
        return startConsumer(groupId, PropertyValueConst.CLUSTERING);
    }

    public Consumer startConsumer(String groupId, String propertyValueConst) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.GROUP_ID, groupId);
        // 设置发送超时时间，单位毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        properties.put(PropertyKeyConst.NAMESRV_ADDR, onsAddr);
        properties.put(PropertyKeyConst.MessageModel, propertyValueConst);
        Consumer consumer = ONSFactory.createConsumer(properties);
        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
        consumer.start();
        return consumer;
    }

}
