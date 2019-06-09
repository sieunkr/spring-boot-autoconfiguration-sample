package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final NaverBlogTemplate naverBlogTemplate;

    public BlogController(NaverBlogTemplate naverBlogTemplate) {
        this.naverBlogTemplate = naverBlogTemplate;
    }

    @GetMapping("blog")
    public Mono<ResponseNaverBlog> findBlogByQuery(){
        return naverBlogTemplate.findBlogByQuery("스프링부트");
    }


}
