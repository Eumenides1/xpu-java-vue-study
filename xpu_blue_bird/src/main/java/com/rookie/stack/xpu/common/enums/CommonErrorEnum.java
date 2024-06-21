package com.rookie.stack.xpu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Getter
@AllArgsConstructor
public enum CommonErrorEnum {
    BUSINESS_ERROR(0, "{0}"),
    SYSTEM_ERROR(-1, "系统出小差了，请稍后再试哦~~"),
    PARAM_INVALID(-2, "参数校验失败{0}"),
    FREQUENCY_LIMIT(-3, "请求太频繁了，请稍后再试哦~~"),
    ;
    private final Integer code;
    private final String msg;
}
