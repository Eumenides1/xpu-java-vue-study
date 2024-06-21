package com.rookie.stack.xpu.common.exception;

import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResult<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println(e.getBindingResult());

        StringBuilder errMsg = new StringBuilder();

        e.getBindingResult().getFieldErrors()
                .forEach(x -> errMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        // 处理全局级别的错误
        e.getBindingResult().getGlobalErrors()
                .forEach(x -> errMsg.append(x.getObjectName()).append(": ").append(x.getDefaultMessage()).append(", "));

        String message = errMsg.toString();

        return ApiResult.fail(message.substring(0, message.length() - 2));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ApiResult<?> businessExceptionHandler(BusinessException e){
        log.error("该用户已经存在啦");
        return ApiResult.fail(e.getErrMsg());
    }


}
