package cn.ipangbo.news.service.impl;

import cn.ipangbo.news.entity.category.Category;
import cn.ipangbo.news.mapper.CategoryMapper;
import cn.ipangbo.news.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public List<Category> getCategoriesByAssociatedType(Integer type) {
        return categoryMapper.selectList(new QueryWrapper<Category>()
                .eq("category_associated_type", type));
    }

    @Override
    public int deleteCategoryByCategoryId(Category category) {
        return categoryMapper.deleteById(category);
    }
}
