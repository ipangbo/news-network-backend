package cn.ipangbo.news.service;

import cn.ipangbo.news.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ArticleServiceTest {
    @Resource
    ArticleService articleService;

    @Test
    public void getArticleCountTest() {
        System.out.println(articleService.getArticleCount());
    }
}
