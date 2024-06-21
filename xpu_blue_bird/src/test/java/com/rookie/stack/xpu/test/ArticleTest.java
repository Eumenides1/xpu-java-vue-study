package com.rookie.stack.xpu.test;

import com.rookie.stack.xpu.dao.UserDao;
import com.rookie.stack.xpu.domain.entity.Articles;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.mapper.ArticlesMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@SpringBootTest
public class ArticleTest {

    @Resource
    private ArticlesMapper articlesMapper;
    @Resource
    private UserDao userDao;
    @Test
    public void insert() {
        Articles article = Articles.builder()
                .articleId("xxxxxxxxx")
                .title("这是一条测试标题")
                .content("这是一篇测试文章")
                .view(0)
                .status(0)
                .category(0)
                .build();
        int insert = articlesMapper.insert(article);
    }
}
