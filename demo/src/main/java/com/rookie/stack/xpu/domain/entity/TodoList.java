package com.rookie.stack.xpu.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jaguarliu
 * @since 2024-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("todo_list")
public class TodoList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 唯一 id
     */
    @TableField("item_id")
    private String itemId;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 事件状态 0待完成 1已完成 -1 已删除
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建日期
     */
    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 更新日期
     */
    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

}
