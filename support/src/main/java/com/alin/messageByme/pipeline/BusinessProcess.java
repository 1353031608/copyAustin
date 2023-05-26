package com.alin.messageByme.pipeline;

/**
 * @Author：raozl
 * @Date：2023/5/5 11:08
 */
public interface BusinessProcess {

    /**
     * 真正处理逻辑
     *
     * @param context
     */
    void process(ProcessContext context);
}
