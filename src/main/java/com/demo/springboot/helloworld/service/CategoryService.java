package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.domain.CategoryExample;
import com.demo.springboot.helloworld.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findAllCategory() {
       // CategoryExample categoryExample = new CategoryExample();
        List<Category> categories = new ArrayList<>();
        categories = categoryMapper.selectByExample(null);
        return categories;
    }
}
