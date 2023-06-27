package com.alin.message.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SmsParam {

    /**
     * 业务ID
     */
    private Long messageTemplateId;

    /**
     * 需要发送短信的手机号列表
     */
    private Set<String> phones;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 渠道商Id
     */
    private Integer supplierId;

    /**
     * 渠道商名字
     */
    private String supplierName;
}
