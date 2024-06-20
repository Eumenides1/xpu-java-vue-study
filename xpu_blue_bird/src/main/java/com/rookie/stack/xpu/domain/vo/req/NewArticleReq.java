package com.rookie.stack.xpu.domain.vo.req;

import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@Data
public class NewArticleReq {

    private String title;

    private String content;

    private Integer category;
}
