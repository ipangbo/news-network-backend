package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.category.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/test/go")
    public Category categoryTest(Category category) {
        System.out.println(category);
        return category;
    }
}
