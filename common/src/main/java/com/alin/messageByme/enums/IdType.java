package com.alin.messageByme.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:05
 * @Desc: 发送ID类型枚举
 */
@AllArgsConstructor
@Getter
@ToString
public enum IdType {
    USER_ID(10, "userId"),
    DID(20, "did"),
    PHONE(30, "phone"),
    OPEN_ID(40, "openId"),
    EMAIL(50, "email");
    private Integer code;
    private String description;


}
