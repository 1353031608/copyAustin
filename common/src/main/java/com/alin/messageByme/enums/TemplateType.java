package com.alin.messageByme.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:05
 * @Desc: 短信模板枚举
 */
@AllArgsConstructor
@Getter
@ToString
public enum TemplateType {
    OPERATION(10, "运营类的模板"),
    TECHNOLOGY(20, "技术类的模板"),
    ;

    private Integer code;
    private String description;

}
