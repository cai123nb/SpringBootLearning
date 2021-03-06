package com.cjyong.spring.conf;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${github.client.clientId}")
    private String authClientId;

    @Value("${github.client.clientSecret}")
    private String authClientSecret;

    @Value("${github.client.userAuthorizationUri}")
    private String authorizationUrl;

    @Value("${github.client.accessTokenUri}")
    private String tokenUrl;

    @Value("${github.client.tokenName}")
    private String tokenName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjyong.spring.main.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(newArrayList(oauth()))
                .securityContexts(newArrayList(securityContext()));
    }

    //ADD description for swagger2
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CJYONG")
                .description("https://github.com/cai123nb")
                .termsOfServiceUrl("https://github.com/cai123nb")
                .version("v1")
                .build();
    }

    @Bean
    SecurityContext securityContext() {
        AuthorizationScope[] scopes = new AuthorizationScope[]{new AuthorizationScope("global", "Access everything")};
        SecurityReference securityReference = SecurityReference
                .builder()
                .reference("oauth2")
                .scopes(scopes)
                .build();
        return SecurityContext
                .builder()
                .securityReferences(newArrayList(securityReference))
                .forPaths(ant("/login"))
                .build();
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("oauth2")
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build();
    }

    List<AuthorizationScope> scopes() {
        return newArrayList(new AuthorizationScope("global", "Access everything"));
    }

    List<GrantType> grantTypes() {
        List<GrantType> grants = newArrayList(new AuthorizationCodeGrant(
                new TokenRequestEndpoint(authorizationUrl, authClientId, authClientSecret),
                new TokenEndpoint(tokenUrl, tokenName)));
        return grants;
    }

}
