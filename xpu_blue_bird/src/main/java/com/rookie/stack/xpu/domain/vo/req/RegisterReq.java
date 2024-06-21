package com.rookie.stack.xpu.domain.vo.req;

import com.rookie.stack.xpu.common.annotation.PasswordEqual;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Data
@PasswordEqual
public class RegisterReq {
    @NotBlank(message = "不能为空啦！你没有名字的吗")
    private String userName;
    @Length(min = 6, max = 12)
    private String password;

    @NotBlank
    @Length(min = 6, max = 12)
    private String retryPassword;

    // TODO 提供一个好用的电话号码匹配正则
    @NotBlank
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号不符合规范")
    private String phone;
}
