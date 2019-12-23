package com.zx.common.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * 消息生产者
 * @author lj
 *
 */
@Configuration
public class OnsProducer {
	
	@Autowired
	private OnsProperties onsProperties;
	
	/**
	 * 生产者
	 */
	@Autowired
    @Qualifier("onsMessageProducer")
    private Producer onsMessageProducer;

	public OnsProperties getOnsProperties() {
		return onsProperties;
	}

	/**
	 * @Description: 集群用户访问记录发送
	 * @Param [topic, mqVo]
	 */
	public SendResult sendClusteringUserLog(String message) {
		Message msg = new Message(onsProperties.studyLabTopic, onsProperties.clusteringTag, message.getBytes());
		return onsMessageProducer.send(msg);
	}
}
