package com.example.springboot1.repositories;

import com.example.springboot1.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> repository;
    private static long counter = 0;

    @PostConstruct
    public void init(){
        repository = new ArrayList<>(List.of(
                new Product(++counter, "Bread", 39),
                new Product(++counter, "Butter", 139),
                new Product(++counter, "Milk", 59),
                new Product(++counter, "Mineral Water", 69),
                new Product(++counter, "Meat", 439)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(repository);
    }

    public Product getProductById(long id){
        for(Product p: repository){
            if(id == p.getId()) return p;
        }
        return null;
    }

}
