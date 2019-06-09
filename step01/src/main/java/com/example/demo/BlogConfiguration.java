package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogAutoConfiguration {

    @Value("${naver.openapi.blogUrl}")
    private String naverOpenApiUrl;

    @Value("${naver.openapi.clientId}")
    private String naverOpenApiClientId;

    @Value("${naver.openapi.clientSecret}")
    private String naverOpenApiClientSecret;

    @Bean
    public NaverBlogTemplate naverBlogTemplate(){
        return new NaverBlogTemplate(naverOpenApiUrl, naverOpenApiClientId, naverOpenApiClientSecret);
    }

}
