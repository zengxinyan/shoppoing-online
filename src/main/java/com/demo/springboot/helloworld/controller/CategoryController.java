package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.utils.Result;
import com.demo.springboot.helloworld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
   private CategoryService categoryService;

    @RequestMapping("/getAllCategory")
    @ResponseBody
    public List<Category> getAllCategory(Model model){
        System.out.println("22222");
        List<Category> categories = categoryService.findAllCategory();
        return categories;
    }
}
