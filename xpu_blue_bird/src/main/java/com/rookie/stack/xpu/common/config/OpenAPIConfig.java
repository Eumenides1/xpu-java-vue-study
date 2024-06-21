package com.rookie.stack.xpu.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("XPU青鸟之翼接口文档")
                        .description("西安工程大学 计卓班实训项目接口文档")
                        .version("v1")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("项目API文档")
                        .url("/"));
    }
    @Bean
    public GroupedOpenApi articleApi() {
        return GroupedOpenApi.builder()
                .group("文章相关接口文档")
                .pathsToMatch("/v1/article/**").build();
    }
}
