package com.example.ProdigyDX.controller;

import com.example.ProdigyDX.exceptions.CategoryException;
import com.example.ProdigyDX.model.Category;
import com.example.ProdigyDX.servicesImp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
public class CategoryController {

    private final CategoryServiceImp categoryServiceImp;

    @Autowired
    public CategoryController(CategoryServiceImp categoryServiceImp) {
        this.categoryServiceImp = categoryServiceImp;
    }

    @ResponseBody
    @GetMapping(value = "/api/categories")
    public List<Category> getAllCategories(){
        return (List<Category>) categoryServiceImp.getAllCategory();
    }

    @ResponseBody
    @PostMapping(value = "/api/category/add")
    public Category addCategory(@RequestBody Category category) throws CategoryException {
        return categoryServiceImp.SaveCategory(category);
    }

    @ResponseBody
    @GetMapping(value = "/api/category/get")
    public Category getCategoryById(int categoryId) throws CategoryException {
        return categoryServiceImp.getCategory(categoryId);
    }

    @ResponseBody
    @PutMapping(value = "/api/category/update")
    public Category updateCategory(@RequestBody Category category) throws CategoryException {
        return categoryServiceImp.SaveCategory(category);
    }

    @DeleteMapping(value = "/api/category/delete")
    public void deleteCategory(int categoryId){
        categoryServiceImp.deleteCategory(categoryId);
    }
}
