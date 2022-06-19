package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.MessageModel;
import cn.ipangbo.news.entity.category.Category;
import cn.ipangbo.news.entity.category.vo.GetCategoriesListByAssociatedTypeVO;
import cn.ipangbo.news.entity.category.vo.GetCategoryByAssociatedTypeVO;
import cn.ipangbo.news.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("getCategoriesListByAssociatedType")
    public GetCategoriesListByAssociatedTypeVO getCategoriesListByAssociatedType(Integer type) {
        List<Category> list = categoryService.getCategoriesByAssociatedType(type);
        List<GetCategoryByAssociatedTypeVO> res = new ArrayList<>();
        for (Category category :list) {
            GetCategoryByAssociatedTypeVO vo = new GetCategoryByAssociatedTypeVO();
            BeanUtils.copyProperties(category, vo);
            res.add(vo);
        }
        if (list.size() > 0) {
            return GetCategoriesListByAssociatedTypeVO.builder().status(200).data(res).build();
        } else {
            return GetCategoriesListByAssociatedTypeVO.builder().status(500).message("未找到与Type" + type + "相关的种类").build();
        }
    }

    @PostMapping("deleteCategoryById")
    public MessageModel deleteCategoryById(@RequestBody Category category) {
        if (categoryService.deleteCategoryByCategoryId(category) == 1) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(500).message("删除类别失败").build();
        }
    }
}
