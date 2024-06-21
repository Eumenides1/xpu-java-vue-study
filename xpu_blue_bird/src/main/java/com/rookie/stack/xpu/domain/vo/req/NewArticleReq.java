package com.rookie.stack.xpu.domain.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@Data
@Schema(name = "新建文章请求实体")
public class NewArticleReq {
    @Schema(description = "文章标题")
    @NotBlank
    private String title;

    @Schema(description = "文章正文")
    @NotBlank
    private String content;

    @Schema(description = "文章分类")
    @NotNull
    private Integer category;
}
