package com.alin.message.script;

import com.alin.message.domain.SmsRecord;
import com.alin.message.domain.SmsParam;

import java.util.List;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:31
 */
public interface SmsScript {
    /**
     * @param smsParam 发送短信参数
     * @return 渠道商接口返回值
     */
    List<SmsRecord> send(SmsParam smsParam);
}
