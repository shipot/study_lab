package com.zx.common.rocketmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Ons服务配置
 *
 * @author lj
 */
@Component
public class OnsProperties {

    /**
     * 集群消息GROUP_ID
     */
    @Value("${aliyun.ons.clusteringGroupId:}")
    public String clusteringGroupId;

    /**
     * 集群消息TAG
     */
    @Value("${aliyun.ons.clusteringTag:}")
    public String clusteringTag;

    /**
     * test主题
     */
    @Value("${aliyun.ons.studyLabTopic:}")
    public String studyLabTopic;

}
