package com.rookie.stack.xpu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eumenides
 * @description  文章状态枚举
 * @date 2024/6/20
 */
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {

    CREATED(0, "初始化"),
    DELETED(3, "已删除");

    private final Integer code;

    private final String desc;

}
