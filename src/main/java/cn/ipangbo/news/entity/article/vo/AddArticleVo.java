package cn.ipangbo.news.entity.article.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AddArticleVo {
    private String articleTitle;
    private String articleAuthor;
    private String articleContentJson;
    private String articleContentHtml;
    private String articleAbstractJson;
    private String articleAbstractHtml;
    private int articleType;
    private int articleCategory;
    private int articleDraft;
}
