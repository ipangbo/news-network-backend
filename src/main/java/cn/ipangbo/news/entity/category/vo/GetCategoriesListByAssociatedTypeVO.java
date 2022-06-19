package cn.ipangbo.news.entity.category.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoriesListByAssociatedTypeVO {
    private int status;
    private List<GetCategoryByAssociatedTypeVO> data;
    private String message;
}
