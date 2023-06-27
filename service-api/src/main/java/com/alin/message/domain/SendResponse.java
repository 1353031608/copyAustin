package com.alin.message.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author：raozl
 * @Date：2023/5/5 11:04
 */
@Data
@AllArgsConstructor
public class SendResponse {
    /**
     * 响应状态
     */
    private String code;
    /**
     * 响应消息体
     */
    private String msg;

}
