package com.rookie.stack.xpu.domain.vo.resp;

import cn.dev33.satoken.stp.SaTokenInfo;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
@Data
public class LoginSuccessResp {
    private SaTokenInfo saTokenInfo;
}
