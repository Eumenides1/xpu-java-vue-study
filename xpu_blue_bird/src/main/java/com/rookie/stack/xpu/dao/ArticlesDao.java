package com.rookie.stack.xpu.dao;

import com.rookie.stack.xpu.domain.entity.Articles;
import com.rookie.stack.xpu.mapper.ArticlesMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@Service
public class ArticlesDao {
    @Resource
    private ArticlesMapper articlesMapper;
    public Integer insertArticle(Articles articles){
        return articlesMapper.insert(articles);
    }
}
