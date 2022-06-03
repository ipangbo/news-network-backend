package cn.ipangbo.news.service.impl;

import cn.ipangbo.news.entity.article.Article;
import cn.ipangbo.news.mapper.ArticleMapper;
import cn.ipangbo.news.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;

    @Override
    public List<Article> getRecent() {
        return articleMapper.selectList(
                new QueryWrapper<Article>()
                        .last("limit 5")
                        .orderByDesc("article_id")
        );
    }

    @Override
    public List<Article> getAllArticleByPages(int current, int size) {
        Page<Article> page = new Page<>(current, size);
        return articleMapper.selectPage(page, null).getRecords();
    }
}
