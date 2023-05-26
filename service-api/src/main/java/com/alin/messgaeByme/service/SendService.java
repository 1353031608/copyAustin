package com.alin.messgaeByme.service;

import com.alin.messageByme.domain.SendRequest;
import com.alin.messageByme.domain.SendResponse;
import com.alin.messgaeByme.domain.BatchSendRequest;

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
