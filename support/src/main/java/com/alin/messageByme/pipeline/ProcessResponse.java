package com.alin.messageByme.pipeline;

import lombok.Builder;
import lombok.Data;

/**
 * @Author：raozl
 * @Date：2023/5/18 10:25
 */
@Builder
@Data
public class ProcessResponse {

    /** 返回值编码 */
    private final String code;

    /** 返回值描述 */
    private final String description;
}
