package com.jone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *http://localhost:8080/swagger-ui.html
 * @author zzj
 * @description Swagger配置
 * @date 2020.09.09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定扫描包下面的注解
                .apis(RequestHandlerSelectors.basePackage("com.jone.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 创建api的基本信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("集成Swagger2构建RESTful APIs")
                .description("集成Swagger2构建RESTful APIs")
                .termsOfServiceUrl("https://www.baidu.com//")
                .contact(new Contact("zoujone","zzj@qq.com","zoujone@163.com"))
                .version("1.0.0")
                .build();
    }
}
