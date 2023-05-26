package com.alin.messgaeByme.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @Author：raozl
 * @Date：2023/5/6 15:53
 */
@Data
@Accessors(chain = true)
public class MessageParam {


    /**
     * @Description: 接收者
     * 多个用,逗号号分隔开
     */
    private String receiver;

    /**
     * @Description: 消息内容中的可变部分
     */
    private Map<String, String> variables;

    /**
     * @Description: 扩展参数
     */
    private Map<String,String> extra;
}
