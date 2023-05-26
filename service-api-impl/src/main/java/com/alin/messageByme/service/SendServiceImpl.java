package com.alin.messageByme.service;

import com.alin.messageByme.domain.SendRequest;
import com.alin.messageByme.domain.SendResponse;
import com.alin.messageByme.domain.SendTaskModel;
import com.alin.messageByme.pipeline.ProcessContext;
import com.alin.messageByme.pipeline.ProcessController;
import com.alin.messageByme.vo.BasicResultVO;
import com.alin.messgaeByme.domain.BatchSendRequest;
import com.alin.messgaeByme.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @Author：raozl
 * @Date：2023/5/5 11:10
 */
public class SendServiceImpl implements SendService {


    @Autowired
    private ProcessController processController;

    @Override
    public SendResponse send(SendRequest sendRequest) {

        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .messageParamList(Arrays.asList(sendRequest.getMessageParam()))
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
    }

    @Override
    public SendResponse batchSend(BatchSendRequest batchSendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(batchSendRequest.getMessageTemplateId())
                .messageParamList(batchSendRequest.getMessageParamList())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(batchSendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
    }


}
