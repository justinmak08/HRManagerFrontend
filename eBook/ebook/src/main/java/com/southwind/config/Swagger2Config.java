package com.southwind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @Description: TODO
 * @author: Devin Liu
 * @date: 2021年01月21日 13:32
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.southwind.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("ebook接口文档")
                        .description("Devin Liu")
                        .version("1.0")
                        .contact(new Contact("柳鑫威","blog.csdn.net","devinliu28@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.v2ex.com")
                        .build());
    }
}