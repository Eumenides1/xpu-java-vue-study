package com.rookie.stack.xpu.controller;

import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.common.exception.BusinessException;
import com.rookie.stack.xpu.common.utils.JwtUtil;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;
import com.rookie.stack.xpu.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
@Tag(name = "文章相关 API")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @PostMapping("/new")
    @Operation(
            summary = "新建文章 API"
    )
    public ApiResult<Void> newArticle(@RequestBody NewArticleReq req){
        boolean result = articleService.newArticle(req);
        if (result) {
            return ApiResult.success("插入成功");
        }
        return ApiResult.fail("插入失败");
    }
}
