package cn.ipangbo.news.entity.category;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("category")
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryAssociatedType;
    private String categoryRoute;
}
