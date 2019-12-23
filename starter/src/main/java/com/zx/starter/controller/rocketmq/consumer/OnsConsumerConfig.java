package com.zx.starter.controller.rocketmq.consumer;

import com.aliyun.openservices.ons.api.Consumer;
import com.zx.common.rocketmq.OnsConfig;
import com.zx.common.rocketmq.OnsProperties;
import com.zx.starter.controller.rocketmq.handler.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/24 19:29
 */
@Slf4j
@Configuration
public class OnsConsumerConfig {

   /* @Autowired
    private OnsConfig onsConfig;

    @Autowired
    private OnsProperties onsProperties;

    @Bean
    public Consumer testTopicClusteringConsumer() {
        Consumer consumer = onsConfig.getClusteringConsumer(onsProperties.clusteringGroupId);
        consumer.subscribe(onsProperties.studyLabTopic, onsProperties.clusteringTag, new OnsClusteringListener());
        consumer.start();
        log.info("{} studyLabTopic主题消费者创建完毕！","testTopicClusteringConsumer");
        return consumer;
    }

    @Autowired
    public void setMessageHandler(MessageHandler messageHandler){
        OnsClusteringListener.messageHandler = messageHandler;
    }*/
}
