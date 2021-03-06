package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.MessageModel;
import cn.ipangbo.news.entity.article.*;
import cn.ipangbo.news.entity.article.vo.*;
import cn.ipangbo.news.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
    public GetRecentVO getRecent() {
        List<Article> articleList = articleService.getRecent();
        List<GetRecentArticleVO> voList = new ArrayList<>();
        for (Article article : articleList) {
            GetRecentArticleVO articleVO = new GetRecentArticleVO();
            BeanUtils.copyProperties(article, articleVO);
            voList.add(articleVO);
        }
        if (voList.size() != 0) {
            return GetRecentVO.builder().status(200).data(voList).build();
        } else {
            return GetRecentVO.builder().status(404).message("未找到最近文章").build();
        }
    }

    @GetMapping("getAll")
    public GetAllVO getAll(int page) {
        List<Article> articleList = articleService.getAllArticleByPages(page, 10);
        List<GetAllArticleVO> voList = new ArrayList<>();
        for (Article article : articleList) {
            GetAllArticleVO articleVO = new GetAllArticleVO();
            BeanUtils.copyProperties(article, articleVO);
            voList.add(articleVO);
        }
        if (voList.size() != 0) {
            return GetAllVO.builder().status(200).data(voList).build();
        } else {
            return GetAllVO.builder().status(404).message("未找到任何文章").build();
        }
    }

    @PostMapping("addArticle")
    public MessageModel addArticle(@RequestBody Article article) {
        if (articleService.addArticle(article) != 0) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(500).message("添加文章失败").build();
        }
    }

    @PostMapping("modifyArticle")
    public MessageModel modifyArticle(@RequestBody Article article) {
        if (articleService.modifyArticle(article) != 0) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(500).message("修改文章失败").build();
        }
    }

    @GetMapping("getArticleCount")
    public MessageModel getArticleCount() {
        return MessageModel.builder().status(200).data(articleService.getArticleCount().toString()).build();
    }

    @PostMapping("deleteArticle")
    public MessageModel deleteArticle(@RequestBody Article article) {
        if (articleService.deleteArticleById(article.getArticleId()) == 1) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(500).message("删除文章失败").build();
        }
    }
}
