package com.alin.message.domain;

import com.alin.message.domain.MessageParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author：raozl
 * @Date：2023/5/5 11:03
 */
@Data
@Accessors(chain = true)
public class SendRequest {

    /**
     * 执行业务类型
     */
    private String code;

    /**
     * 消息模板Id
     */
    private Long messageTemplateId;


    /**
     * 消息相关的参数
     */
    private MessageParam messageParam;

}
