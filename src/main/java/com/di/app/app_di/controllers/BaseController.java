package com.di.app.app_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.di.app.app_di.models.Product;
import com.di.app.app_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class BaseController {

    @Autowired
    private ProductService serviceProduct;

    @GetMapping
    public List<Product> list(){
        return serviceProduct.findAll();
    }
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return serviceProduct.findById(id);
    }

}
