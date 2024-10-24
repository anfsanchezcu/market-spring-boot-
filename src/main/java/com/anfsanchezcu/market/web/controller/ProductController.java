package com.anfsanchezcu.market.web.controller;

import com.anfsanchezcu.market.domain.Product;
import com.anfsanchezcu.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService ps;

    @GetMapping("/all")
    public List<Product> getAll(){
        return ps.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
         return ps.getProduct(productId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return ps.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody  Product product){
        return ps.save(product);
    }
    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId){
        return ps.delete(productId);
    }
}
