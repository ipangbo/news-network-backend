package cn.ipangbo.news.entity.article;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@TableName("article")
public class Article {
    @TableId(type = IdType.AUTO)
    private int articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleContentJson;
    private String articleContentHtml;
    private String articleAbstractJson;
    private String articleAbstractHtml;
    private int articleType;
    private int articleCategory;
    private int articleDraft;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime articleCreateTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime articleModifyTime;
}
