package com.anfsanchezcu.market.domain.service;


import com.anfsanchezcu.market.domain.Product;
import com.anfsanchezcu.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int categoryId){
        return productRepository.getProduct(categoryId);
    }

    public Optional<List<Product>>  getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save (Product product){
        return productRepository.save(product);
    }
    public boolean delete(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }
        return false;
    }
}
