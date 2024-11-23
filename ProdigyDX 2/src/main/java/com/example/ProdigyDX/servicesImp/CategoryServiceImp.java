package com.example.ProdigyDX.servicesImp;

import com.example.ProdigyDX.exceptions.CategoryException;
import com.example.ProdigyDX.exceptions.ProductException;
import com.example.ProdigyDX.model.Category;
import com.example.ProdigyDX.model.Product;
import com.example.ProdigyDX.repository.CategoryRepository;
import com.example.ProdigyDX.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryServices {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category SaveCategory(Category product) throws CategoryException {
        Object categoryObject = categoryRepository.save(product);
        if (categoryObject != null) {
            return (Category) categoryObject;
        } else {
            throw new CategoryException("Category not added");
        }
    }

    @Override
    public Category getCategory(int productId) throws CategoryException {
        Optional<Category> categoryOptional = categoryRepository.findById(productId);
        if (categoryOptional.isPresent()){
            return categoryOptional.get();
        }else {
            throw new CategoryException("Category not Present");
        }
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}

