package cn.ipangbo.news.entity.article;

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
