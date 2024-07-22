package com.di.app.app_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.di.app.app_di.repositories.ProductRepository;
import com.di.app.app_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    
    @Bean("productJson")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
