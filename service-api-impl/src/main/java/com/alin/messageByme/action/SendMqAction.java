package com.alin.messageByme.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alin.messageByme.domain.SendTaskModel;
import com.alin.messageByme.enums.RespStatusEnum;
import com.alin.messageByme.pipeline.BusinessProcess;
import com.alin.messageByme.pipeline.ProcessContext;
import com.alin.messageByme.vo.BasicResultVO;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Author：raozl
 * @Date：2023/5/19 11:05
 * @Desc: 将消息发送到MQ
 */
@Slf4j
public class SendMqAction implements BusinessProcess {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${austin.topic.name}")
    private String topicName;

    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
        try {
            kafkaTemplate.send(topicName, JSON.toJSONString(sendTaskModel.getTaskInfo(),
                    new SerializerFeature[]{SerializerFeature.WriteClassName}));
        } catch (Exception e) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("send kafka fail! e:{}", Throwables.getStackTraceAsString(e));
        }
    }
}
