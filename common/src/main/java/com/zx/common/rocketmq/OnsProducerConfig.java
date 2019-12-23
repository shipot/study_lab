package com.zx.common.rocketmq;

import com.aliyun.openservices.ons.api.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列生产者配置
 */
@Slf4j
@Configuration
public class OnsProducerConfig {
	
	 @Autowired
	 private OnsConfig onsMqConfig;
	 
	/**
	 * 生产者
	 */
	@Bean(name = "onsMessageProducer")
	public Producer onsMessageProducer() {
		Producer producer = onsMqConfig.getProducer();
		log.info("{}  生产者创建完毕", "onsMessageProducer");
		return producer;
	}

}
