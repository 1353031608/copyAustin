package com.alin.message.controller;

import com.alin.message.domain.SendRequest;
import com.alin.message.domain.SendResponse;
import com.alin.message.handle.SmsHandler;
import com.alin.message.domain.TaskInfo;
import com.alin.message.vo.BasicResultVO;
import com.alin.message.domain.MessageParam;
import com.alin.message.enums.BusinessCode;
import com.alin.message.service.SendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author：raozl
 * @Date：2023/5/5 10:34
 */
@RestController
@RequestMapping("/send")
public class SendController {


    @Resource
    private SendService sendService;

    @GetMapping("/sendSmsV2")
    public SendResponse sendSmsV2(String phone) {

        /**
         *
         * messageTemplate Id 为1 的模板内容
         * {"auditStatus":10,"auditor":"yyyyyyz","created":1636978066,"creator":"yyyyc","deduplicationTime":1,"expectPushTime":"0","flowId":"yyyy","id":1,"idType":20,"isDeleted":0,"isNightShield":0,"msgContent":"{\"content\":\"{$contentValue}\"}","msgStatus":10,"msgType":10,"name":"test短信","proposer":"yyyy22","sendAccount":66,"sendChannel":30,"team":"yyyt","templateType":10,"updated":1636978066,"updator":"yyyyu"}
         *
         */

        // 文案参数
        Map<String, String> variables = new HashMap<>();
        variables.put("contentValue", "6666");

        MessageParam messageParam = new MessageParam().setReceiver(phone).setVariables(variables);

        // ID为1的消息模板
        SendRequest sendRequest = new SendRequest().setCode(BusinessCode.COMMON_SEND.getCode())
                .setMessageTemplateId(1L)
                .setMessageParam(messageParam);

        SendResponse response = sendService.send(sendRequest);

        return response;
    }

}
