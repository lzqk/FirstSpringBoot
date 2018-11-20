package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//通过@Configuration注解让spring加载该配置
@Configuration
//@EnableSwagger2注解来启动Swagger2
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket configSpringfoxDocketForAll() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("User Test REST API文档")
                .description("使用Swagger UI构建SpringMVC REST风格的可视化文档")
                .termsOfServiceUrl("http://127.0.0.1:8081/swagger-ui.html")
                .contact("L.K.")
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}
