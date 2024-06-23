package com.rookie.stack.xpu.service.adapter;

import com.rookie.stack.xpu.common.context.RequestContext;
import com.rookie.stack.xpu.domain.entity.Articles;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;

import java.util.UUID;

import static com.rookie.stack.xpu.common.enums.ArticleStatusEnum.CREATED;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
public class NewArticleReqToArticle {
    public static Articles newArticleReqAdapter(NewArticleReq req){
        Users user = RequestContext.getCurrentUser();
        String uuid = UUID.randomUUID().toString();
        return Articles.builder()
                .articleId(uuid)
                .title(req.getTitle())
                .content(req.getContent())
                .category(req.getCategory())
                .status(CREATED.getCode())
                // 阅读数初始化
                .view(0)
                .createBy(user.getUserId())
                .build();
    }
}
