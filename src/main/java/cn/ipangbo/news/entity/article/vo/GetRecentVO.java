package cn.ipangbo.news.entity.article.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetRecentVO {
    private List<GetRecentArticleVO> data;
    private int status;
    private String message;

}
