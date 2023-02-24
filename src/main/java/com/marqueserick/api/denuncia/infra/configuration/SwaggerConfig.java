package com.marqueserick.api.denuncia.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Component
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.marqueserick.api.denuncia"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    @Bean
    UiConfiguration uiConfig(){
        return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .build();
    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("DenunciaAPI")
                .description("API para registrar denúncias")
                .version("1.0.0")
                .contact(new Contact("Erick Marques","https://linkedin.com/in/marqueserick","erickmarques43@gmail.com"))
                .build();
    }
}
