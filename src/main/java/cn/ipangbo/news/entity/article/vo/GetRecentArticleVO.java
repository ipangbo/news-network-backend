package cn.ipangbo.news.entity.article.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetRecentArticleVO {
    private int articleId;
    private String articleTitle;
    private LocalDateTime articleModifyTime;
}
