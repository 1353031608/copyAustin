package com.alin.message.config;

import com.alin.message.action.AssembleAction;
import com.alin.message.action.PreParamAction;
import com.alin.message.action.SendMqAction;
import com.alin.message.pipeline.BusinessProcess;
import com.alin.message.pipeline.ProcessController;
import com.alin.message.pipeline.ProcessTemplate;
import com.alin.message.enums.BusinessCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：raozl
 * @Date：2023/5/19 11:19
 */
@Configuration
public class PipelineConfig {


    /**
     * 普通发送执行流程
     * 1. 参数校验
     * 2. 组装参数
     * 3. 发送消息至MQ
     * @return
     */
    @Bean("commonSendTemplate")
    public ProcessTemplate commonSendTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        ArrayList<BusinessProcess> processList = new ArrayList<>();

        processList.add(preParamAction());
        processList.add(assembleAction());
        processList.add(sendMqAction());

        processTemplate.setProcessList(processList);
        return processTemplate;
    }

    /**
     * pipeline流程控制器
     * 目前暂定只有 普通发送的流程
     * 后续扩展则加BusinessCode和ProcessTemplate
     * @return
     */
    @Bean
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>();
        templateConfig.put(BusinessCode.COMMON_SEND.getCode(), commonSendTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }


    /**
     * 组装参数Action
     * @return
     */
    @Bean
    public AssembleAction assembleAction() {
        return new AssembleAction();
    }

    /**
     * 参数校验Action
     * @return
     */
    @Bean
    public PreParamAction preParamAction() {
        return new PreParamAction();
    }

    /**
     * 发送消息至MQ的Action
     * @return
     */
    @Bean
    public SendMqAction sendMqAction() {
        return new SendMqAction();
    }

}
