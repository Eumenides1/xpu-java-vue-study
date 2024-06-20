package com.rookie.stack.xpu.service.impl;

import com.rookie.stack.xpu.domain.entity.Articles;
import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;
import com.rookie.stack.xpu.mapper.ArticlesMapper;
import com.rookie.stack.xpu.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@Service
public class ArticlesServiceImpl implements ArticleService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public boolean newArticle(NewArticleReq req) {
        String uuid = UUID.randomUUID().toString();
        Articles articles = Articles.builder()
                .articleId(uuid)
                .title(req.getTitle())
                .content(req.getContent())
                .category(req.getCategory())
                // TODO
                .status(0)
                .view(0)
                .createBy("用户 id")
                .build();
        // 受影响的行数
        int insert = articlesMapper.insert(articles);
        return insert == 1;
    }
}
