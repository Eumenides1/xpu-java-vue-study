package com.rookie.stack.xpu.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author eumenides
 * @description 文章表实体
 * @date 2024/6/20
 */
@Data
@Builder
public class Articles {
    @TableId(type = IdType.AUTO)
    private Integer id ;
    /** 唯一 ID */
    private String articleId ;
    /** 文章标题 */
    private String title ;
    /** 正文 */
    private String content ;
    /** 分类id */
    private Integer category ;
    /** 状态 */
    private Integer status ;
    /** 查看数 */
    private Integer view ;
    /** 创建人 */
    private String createBy ;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime ;
    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime ;

}
