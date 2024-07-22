package com.di.app.app_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.di.app.app_di.models.Product;
import com.di.app.app_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository repositoryProduct;

    @Value("${config.tax.price}")
    private double tax;

    @Autowired
    public void setRepositoryProduct(@Qualifier("productJson")ProductRepository repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }
    

    public List<Product> findAll(){
        return repositoryProduct.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            // p.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repositoryProduct.findById(id);        
    }

}
