package com.alin.message.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:05
 * @Desc: 短信发送状态枚举
 */
@AllArgsConstructor
@Getter
@ToString
public enum SmsStatus {
    SEND_SUCCESS(10,"调用渠道接口发送成功"),
    RECEIVE_SUCCESS(20,"用户收到短信(收到渠道短信回执，状态成功)"),
    RECEIVE_FAIL(30, "用户收不到短信(收到渠道短信回执，状态失败)");
    private Integer code;
    private String description;


}
