package cn.ipangbo.news.entity.article.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllArticleVO {
    private int articleId;
    private String articleTitle;
    private int articleType;
    private int articleCategory;
    private int articleDraft;
    private LocalDateTime articleModifyTime;
}
