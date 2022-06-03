package cn.ipangbo.news.entity.article.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetAllArticleVo {
    private int articleId;
    private String articleTitle;
    private int articleType;
    private int articleCategory;
    private int articleDraft;
    private LocalDateTime articleModifyTime;
}
