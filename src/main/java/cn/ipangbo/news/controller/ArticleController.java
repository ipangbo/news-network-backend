package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.MessageModel;
import cn.ipangbo.news.entity.article.*;
import cn.ipangbo.news.entity.article.vo.GetAllArticleVO;
import cn.ipangbo.news.entity.article.vo.GetAllVO;
import cn.ipangbo.news.entity.article.vo.GetRecentArticleVO;
import cn.ipangbo.news.entity.article.vo.GetRecentVO;
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
        GetRecentArticleVO articleVO = new GetRecentArticleVO();
        for (Article article : articleList) {
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
        GetAllArticleVO articleVO = new GetAllArticleVO();
        for (Article article : articleList) {
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
            return MessageModel.builder().status(400).message("添加文章失败").build();
        }
    }

    @PostMapping("modifyArticle")
    public MessageModel modifyArticle(@RequestBody Article article) {
        if (articleService.modifyArticle(article) != 0) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(400).message("修改文章失败").build();
        }
    }
}
