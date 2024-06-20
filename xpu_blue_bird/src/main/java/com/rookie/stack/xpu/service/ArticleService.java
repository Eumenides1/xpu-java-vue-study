package com.rookie.stack.xpu.service;

import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
public interface ArticleService {

    boolean newArticle(NewArticleReq req);

}
