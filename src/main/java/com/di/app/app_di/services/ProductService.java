package com.di.app.app_di.services;

import java.util.List;

import com.di.app.app_di.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
