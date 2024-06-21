package com.rookie.stack.xpu.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Data
@Builder
public class Users {
    @TableId(type = IdType.AUTO)
    /** 主键 id */
    private Integer id ;
    /** 用户唯一 ID */
    @Schema(description = "用户唯一 ID")
    private String userId ;
    /** 用户名 */
    @Schema(description = "用户名")
    private String username;
    /** 密码 */
    private String password;
    /** 用户电话 */
    private String phone;
    /** 用户电子邮件 */
    private String email ;
    /** 用户头像 */
    private String avatar ;
    /** 个人描述 */
    private String desc ;
    /** 学号 */
    private Integer stuNum;
    /** 用户状态 */
    private Integer status ;
    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime ;
    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime ;
}
