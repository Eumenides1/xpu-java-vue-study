package com.rookie.stack.xpu.common.domain.resp;
import com.rookie.stack.xpu.common.enums.CommonErrorEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Data
@Schema(name = "基础的返回对象")
public class ApiResult<T> {
    @Schema(description = "响应码")
    private Integer code;
    @Schema(description = "错误消息")
    private String message;
    @Schema(description = "是否请求成功")
    private boolean success;
    @Schema(description = "响应数据")
    private T data;

    public static <T> ApiResult<T> success() {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(HttpStatus.OK.value());
        apiResult.setSuccess(Boolean.TRUE);
        apiResult.setData(null);
        return apiResult;
    }
    public static <T> ApiResult<T> success(String message) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(0);
        apiResult.setMessage(message);
        apiResult.setSuccess(Boolean.TRUE);
        apiResult.setData(null);
        return apiResult;
    }
    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setData(data);
        apiResult.setSuccess(Boolean.TRUE);
        return apiResult;
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(CommonErrorEnum.BUSINESS_ERROR.getCode());
        apiResult.setMessage(message);
        apiResult.setSuccess(Boolean.FALSE);
        apiResult.setData(null);
        return apiResult;
    }
}
