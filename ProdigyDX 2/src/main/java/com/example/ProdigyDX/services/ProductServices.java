package com.example.ProdigyDX.services;

import com.example.ProdigyDX.exceptions.ProductException;
import com.example.ProdigyDX.model.Product;

import java.util.List;

public interface ProductServices{

    public List<Product> getAllProducts();

    public Product saveProduct(Product product) throws ProductException;

    public Product getProductById(int productId) throws ProductException;

    public Product updateProduct(Product product);

    public void deleteProduct(int id);
}
