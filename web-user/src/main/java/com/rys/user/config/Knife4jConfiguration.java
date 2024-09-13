package com.rys.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * knife文档配置类
 *
 * @author chenxh
 * @version 1.0
 * @date 2021/4/20 11:26 上午
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {


    @Bean(value = "distribution")
    public Docket defaultApiV1() {
        String groupName = "心理辅导平台";
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            //分组名称
            .host("https://www.baidu.com")
            .groupName(groupName)
            .select()
            //这里指定Controller扫描包路径
            .apis(RequestHandlerSelectors.basePackage("com.rys.user.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
            //.title("swagger-bootstrap-ui-demo RESTful APIs")
            .description("# swagger-bootstrap-ui-demo RESTful APIs")
            .termsOfServiceUrl("http://www.xx.com/")
            .version("1.0")
            .build();
    }
}
