package com.rookie.stack.xpu.service.impl;

import com.rookie.stack.xpu.dao.ArticlesDao;
import com.rookie.stack.xpu.domain.entity.Articles;
import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;
import com.rookie.stack.xpu.mapper.ArticlesMapper;
import com.rookie.stack.xpu.service.ArticleService;
import com.rookie.stack.xpu.service.adapter.NewArticleReqToArticle;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */

// controller 路由分发
// service 参数校验 -> 文本一个审核 -> 分类存不存在 业务逻辑处理 数据库层的操作
@Service
public class ArticlesServiceImpl implements ArticleService {

    @Resource
    private ArticlesDao articlesDao;
    @Override
    public boolean newArticle(NewArticleReq req) {
        // 组装业务实体
        Articles articles = NewArticleReqToArticle.newArticleReqAdapter(req);
        // 执行插入逻辑
        int insert = articlesDao.insertArticle(articles);
        return insert == 1;
    }
}
