package com.example.ProdigyDX.services;

import com.example.ProdigyDX.exceptions.CategoryException;
import com.example.ProdigyDX.model.Category;

import java.util.List;

public interface CategoryServices {

    public List<Category> getAllCategory();

    public Category SaveCategory(Category category) throws CategoryException;

    public Category getCategory(int categoryId) throws CategoryException;

    public Category updateCategory(Category category);

    public void deleteCategory(int CategoryId);
}
