package com.example.ProdigyDX.servicesImp;

import com.example.ProdigyDX.exceptions.ProductException;
import com.example.ProdigyDX.model.Product;
import com.example.ProdigyDX.repository.ProductRepository;
import com.example.ProdigyDX.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products;
    }
    @Override
    public Product saveProduct(Product product) throws ProductException{
        Object productObject = productRepository.save(product);
        if (productObject != null) {
            return (Product) productObject;
        } else {
            throw new ProductException("Product not added");
        }
    }

    @Override
    public Product getProductById(int productId) throws ProductException{
        Optional<Product> productObject = productRepository.findById(productId);
        if (productObject.isPresent()) {
            return productObject.get();
        } else {
            throw new ProductException("Product not added");
        }
    }

    @Override
    public Product updateProduct(Product product) {
        return (Product) productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
