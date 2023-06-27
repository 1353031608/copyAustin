package com.alin.message.handle;

import com.alin.message.domain.TaskInfo;
import com.alin.message.vo.BasicResultVO;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:24
 */
public interface Handler {

    boolean doHandler(TaskInfo taskInfo);
}
