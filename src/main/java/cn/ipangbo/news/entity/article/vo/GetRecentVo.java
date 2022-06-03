package cn.ipangbo.news.entity.article.vo;

import cn.ipangbo.news.entity.article.vo.GetRecentArticleVo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetRecentVo {
    private List<GetRecentArticleVo> data;
    private int status;
    private String message;

}
