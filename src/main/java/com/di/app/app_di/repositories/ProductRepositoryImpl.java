package com.di.app.app_di.repositories;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.di.app.app_di.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
        List<Product> products;

        public ProductRepositoryImpl() {
            this.products = Arrays.asList(
                new Product(1L, "Laptop", 450L),
                new Product(2L, "Smartphone", 200L),
                new Product(3L, "Tablet", 120L),
                new Product(4L, "Monitor", 800L),
                new Product(5L, "Keyboard", 150L),
                new Product(6L, "Mouse", 800L),
                new Product(7L, "Printer", 700L),
                new Product(8L, "External Hard Drive", 350L),
                new Product(9L, "Headphones", 200L),
                new Product(10L, "Webcam", 250L)               
            );
        }
        @Override
        public List<Product> findAll(){
           return products; 
        }
        @Override
        public Product findById(Long id){
            return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        }
}