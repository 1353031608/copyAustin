package com.alin.messageByme.pipeline;

import lombok.Data;

import java.util.List;

/**
 * 业务执行模板（把责任链的逻辑串起来）
 *
 * @Author：raozl
 * @Date：2023/5/5 11:10
 */
@Data
public class ProcessTemplate {

    private List<BusinessProcess> processList;

    public List<BusinessProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(List<BusinessProcess> processList) {
        this.processList = processList;
    }
}
