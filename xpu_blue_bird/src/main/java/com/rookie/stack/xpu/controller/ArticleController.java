package com.rookie.stack.xpu.controller;

import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;
import com.rookie.stack.xpu.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eumenides
 * @description
 * @date 2024/6/20
 */
@RestController
@RequestMapping("/v1/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @PostMapping("/new")
    public String newArticle(@RequestBody NewArticleReq req){
        boolean result = articleService.newArticle(req);
        if (result) {
            return "插入成功";
        }
        return "插入失败";
    }
}
