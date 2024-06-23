package com.rookie.stack.xpu.service.adapter;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.rookie.stack.xpu.common.enums.UserStatusEnum;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
public class RegisterAdapter {
    public static Users registerReqToUser(RegisterReq req){
        return Users.builder()
                .userId(UUID.randomUUID().toString())
                .username(req.getUserName())
                .phone(req.getPhone())
                .status(UserStatusEnum.CREATED.getCode())
                .build();
    }


}
