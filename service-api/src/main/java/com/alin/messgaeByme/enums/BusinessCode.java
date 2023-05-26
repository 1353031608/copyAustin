package com.alin.messgaeByme.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author：raozl
 * @Date：2023/5/6 16:03
 */
@Getter
@AllArgsConstructor
@ToString
public enum BusinessCode {
    COMMON_SEND("send", "普通发送"),

    RECALL("recall", "撤回消息");


    /** code 关联着责任链的模板 */
    private String code;

    /** 类型说明 */
    private String description;
}
