package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.article.*;
import cn.ipangbo.news.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Resource
    ArticleService articleService;

    @GetMapping("getRecent")
    public GetRecentVo getRecent() {
        List<Article> articleList = articleService.getRecent();
        List<GetRecentArticleVo> voList = new ArrayList<>();
        for (Article article : articleList) {
            voList.add(GetRecentArticleVo.builder()
                    .articleId(article.getArticleId())
                    .articleTitle(article.getArticleTitle())
                    .articleModifyTime(article.getArticleModifyTime())
                    .build());
        }
        if (voList.size() != 0) {
            return GetRecentVo.builder().status(200).data(voList).build();
        } else {
            return GetRecentVo.builder().status(404).message("未找到最近文章").build();
        }
    }

    @GetMapping("getAll")
    public GetAllVo getAll(int page) {
        List<Article> articleList = articleService.getAllArticleByPages(page, 10);
        List<GetAllArticleVo> voList = new ArrayList<>();
        for (Article article : articleList) {
            voList.add(GetAllArticleVo.builder()
                    .articleId(article.getArticleId())
                    .articleTitle(article.getArticleTitle())
                    .articleType(article.getArticleType())
                    .articleCategory(article.getArticleCategory())
                    .articleDraft(article.getArticleDraft())
                    .articleModifyTime(article.getArticleModifyTime())
                    .build());
        }
        if (voList.size() != 0) {
            return GetAllVo.builder().status(200).data(voList).build();
        } else {
            return GetAllVo.builder().status(404).message("未找到任何文章").build();
        }

    }
}
