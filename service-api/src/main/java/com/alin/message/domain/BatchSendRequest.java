package com.alin.message.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @Author：raozl
 * @Date：2023/5/6 15:53
 */
@Data
public class BatchSendRequest {

    /**
     * 执行业务类型
     * 必传,参考 BusinessCode枚举
     */
    @NotNull
    private String code;


    /**
     * 消息模板Id
     * 必传
     */
    @NotNull
    private Long messageTemplateId;


    /**
     * 消息相关的参数
     */
    @NotNull
    private List<MessageParam> messageParamList;
}
