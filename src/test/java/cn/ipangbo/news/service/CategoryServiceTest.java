package cn.ipangbo.news.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class CategoryServiceTest {
    @Resource
    CategoryService categoryService;

    @Test
    void getCategoriesByAssociatedTypeTest() {
        System.out.println(categoryService.getCategoriesByAssociatedType(2));
    }
}
