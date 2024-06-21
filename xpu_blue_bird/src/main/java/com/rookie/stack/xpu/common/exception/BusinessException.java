package com.rookie.stack.xpu.common.exception;

import com.rookie.stack.xpu.common.enums.CommonErrorEnum;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Data
public class BusinessException extends RuntimeException{

    protected Integer errCode;

    protected String errMsg;
    public BusinessException(){
        super();
    }
    public BusinessException(String errMsg){
        super(errMsg);
        this.errCode = CommonErrorEnum.BUSINESS_ERROR.getCode();
        this.errMsg = errMsg;
    }
}
