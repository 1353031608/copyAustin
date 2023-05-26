package com.alin.messageByme.action;

import cn.hutool.core.collection.CollUtil;
import com.alin.messageByme.domain.SendTaskModel;
import com.alin.messageByme.enums.RespStatusEnum;
import com.alin.messageByme.pipeline.BusinessProcess;
import com.alin.messageByme.pipeline.ProcessContext;
import com.alin.messageByme.vo.BasicResultVO;
import com.alin.messgaeByme.domain.MessageParam;

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
