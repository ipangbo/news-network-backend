package cn.ipangbo.news.entity.category.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryByAssociatedTypeVO {
    private int categoryId;
    private String categoryName;
    private String categoryRoute;
}
