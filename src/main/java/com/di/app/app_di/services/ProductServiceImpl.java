package com.di.app.app_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.app.app_di.models.Product;
import com.di.app.app_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repositoryProduct;

    public List<Product> findAll(){
        return repositoryProduct.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * 1.45d;
            // Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProduct = (Product) p.clone();
            // p.setPrice(priceImp.longValue());
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repositoryProduct.findById(id);        
    }
}
