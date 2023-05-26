package com.alin.messageByme.kafkaTest;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author：raozl
 * @Date：2023/5/6 11:04
 */
@Data
@Accessors(chain = true)
public class UserLog {
    private String username;
    private String userid;
    private String state;
}
