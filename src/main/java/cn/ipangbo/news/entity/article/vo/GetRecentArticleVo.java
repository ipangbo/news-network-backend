package cn.ipangbo.news.entity.article.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetRecentArticleVo {
    private int articleId;
    private String articleTitle;
    private LocalDateTime articleModifyTime;
}
