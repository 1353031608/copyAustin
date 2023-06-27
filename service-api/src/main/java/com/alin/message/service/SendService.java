package com.alin.message.service;

import com.alin.message.domain.SendRequest;
import com.alin.message.domain.SendResponse;
import com.alin.message.domain.BatchSendRequest;

/**
 * @Author：raozl
 * @Date：2023/5/5 11:04
 */
public interface SendService {

    /**
     * 单文案发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);


    /**
     * 多文案发送接口
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);
}
