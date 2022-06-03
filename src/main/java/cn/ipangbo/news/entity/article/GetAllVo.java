package cn.ipangbo.news.entity.article;

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
