package com.di.app.app_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.di.app.app_di.models.Product;
import com.di.app.app_di.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class BaseController {
    private ProductServiceImpl serviceProduct = new ProductServiceImpl();

    @GetMapping
    public List<Product> list(){
        return serviceProduct.findAll();
    }
    @GetMapping
    public Product show(@PathVariable Long id){
        return serviceProduct.findById(id);
    }

}
