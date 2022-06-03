package cn.ipangbo.news.entity.article.vo;

import cn.ipangbo.news.entity.article.vo.GetAllArticleVo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllVo {
    private List<GetAllArticleVo> data;
    private int status;
    private String message;
}
