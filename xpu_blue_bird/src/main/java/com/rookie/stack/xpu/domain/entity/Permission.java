package com.rookie.stack.xpu.domain.entity;

import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
@Data
public class Permission {
    private Integer id;
    private String permissionValue;
    private Integer roleId;
}
