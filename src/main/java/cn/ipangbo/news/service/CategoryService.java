package cn.ipangbo.news.service;

import cn.ipangbo.news.entity.category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoriesByAssociatedType(Integer type);
    int deleteCategoryByCategoryId(Category category);
}
