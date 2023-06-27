package com.alin.message.action;

import cn.hutool.core.collection.CollUtil;
import com.alin.message.domain.SendTaskModel;
import com.alin.message.enums.RespStatusEnum;
import com.alin.message.pipeline.BusinessProcess;
import com.alin.message.pipeline.ProcessContext;
import com.alin.message.vo.BasicResultVO;
import com.alin.message.domain.MessageParam;

import java.util.List;

/**
 * @Author：raozl
 * @Date：2023/5/18 11:31
 * @description 前置参数校验
 */
public class PreParamAction implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();

        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true);
            context.setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
        }
    }
}
