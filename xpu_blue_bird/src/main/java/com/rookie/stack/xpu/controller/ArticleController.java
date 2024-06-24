package com.rookie.stack.xpu.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.common.exception.BusinessException;
import com.rookie.stack.xpu.common.utils.JwtUtil;
import com.rookie.stack.xpu.domain.vo.req.NewArticleReq;
import com.rookie.stack.xpu.service.ArticleService;
import com.rookie.stack.xpu.service.impl.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Resource
    private PermissionService permissionService;
    @PostMapping("/new")
    @Operation(
            summary = "新建文章 API"
    )
    public ApiResult<Void> newArticle(@RequestBody NewArticleReq req, HttpServletRequest request){
        boolean result = articleService.newArticle(req);
        if (result) {
            return ApiResult.success("插入成功");
        }
        return ApiResult.fail("插入失败");
    }
}
