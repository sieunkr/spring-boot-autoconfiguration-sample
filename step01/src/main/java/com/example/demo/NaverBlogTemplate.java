package com.example.demo;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class NaverBlogTemplate implements BlogTemplate {

    private String naverOpenApiUrl;

    private String naverOpenApiClientId;

    private String naverOpenApiClientSecret;

    public NaverBlogTemplate(String naverOpenApiUrl, String naverOpenApiClientId, String naverOpenApiClientSecret){
        this.naverOpenApiUrl = naverOpenApiUrl;
        this.naverOpenApiClientId = naverOpenApiClientId;
        this.naverOpenApiClientSecret = naverOpenApiClientSecret;
    }

    public Mono<ResponseNaverBlog> findBlogByQuery(String query) {
        return WebClient.create(naverOpenApiUrl)
                .method(HttpMethod.GET)
                .uri("?query=" + query)
                .header("X-Naver-Client-Id", naverOpenApiClientId)
                .header("X-Naver-Client-Secret", naverOpenApiClientSecret)
                .retrieve()
                .bodyToMono(ResponseNaverBlog.class);
    }
}
