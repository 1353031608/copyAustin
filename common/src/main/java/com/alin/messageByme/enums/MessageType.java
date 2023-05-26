package com.alin.messageByme.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:05
 * @Desc: 发送的消息类型枚举
 */
@AllArgsConstructor
@Getter
@ToString
public enum MessageType {
    NOTICE(10,"通知类消息"),
    MARKETING(20,"营销类消息"),
    AUTH_CODE(30,"验证码消息")
    ;
    private Integer code;
    private String description;
}
