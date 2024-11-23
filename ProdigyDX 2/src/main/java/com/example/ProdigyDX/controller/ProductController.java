package com.example.ProdigyDX.controller;

import com.example.ProdigyDX.exceptions.ProductException;
import com.example.ProdigyDX.model.Product;
import com.example.ProdigyDX.servicesImp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductServiceImp productService;

    @Autowired
    public ProductController(ProductServiceImp productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/api/products")
    @ResponseBody
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping(value = "/api/products/add")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) throws ProductException {
        return productService.saveProduct(product);
    }

    @GetMapping(value = "/api/products/get")
    @ResponseBody
    public Product getProduct(int productId) throws ProductException {
        return productService.getProductById(productId);
    }

    @PutMapping(value = "/api/products/update")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) throws ProductException {
        return productService.saveProduct(product);
    }

    @DeleteMapping(value = "/api/products/delete")
    public void deleteProduct(int productId){
         productService.deleteProduct(productId);
    }

}

