package com.alin.messageByme.handle;

import com.alin.messageByme.domain.TaskInfo;
import com.alin.messageByme.vo.BasicResultVO;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:24
 */
public interface Handler {

    boolean doHandler(TaskInfo taskInfo);
}
