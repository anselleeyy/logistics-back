package com.ansel;

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

@Configuration
@EnableSwagger2
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ansel.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("国际物流管理系统 API 文档")
        		.contact(new Contact("Ansel Lee", "https://www.ltysyn.cn", ""))
        		.version("1.0")
        		.description("API 描述")
        		.build();
    }

}
