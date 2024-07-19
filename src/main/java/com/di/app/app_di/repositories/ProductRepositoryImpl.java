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
                new Product(1L, "Laptop", 4500000L),
                new Product(2L, "Smartphone", 2000000L),
                new Product(3L, "Tablet", 1200000L),
                new Product(4L, "Monitor", 800000L),
                new Product(5L, "Keyboard", 150000L),
                new Product(6L, "Mouse", 80000L),
                new Product(7L, "Printer", 700000L),
                new Product(8L, "External Hard Drive", 350000L),
                new Product(9L, "Headphones", 200000L),
                new Product(10L, "Webcam", 250000L)               
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