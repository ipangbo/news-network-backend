package cn.ipangbo.news.service;

import cn.ipangbo.news.entity.article.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    List<Article> getRecent();

    List<Article> getAllArticleByPages(int current, int size);

    int addArticle(Article article);
}
