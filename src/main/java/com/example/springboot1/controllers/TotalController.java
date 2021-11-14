package com.example.springboot1.controllers;

import com.example.springboot1.data.Product;
import com.example.springboot1.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TotalController {

    private ProductRepository repository;

    public TotalController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public String showAllProducts(Model model){
        model.addAttribute("prs", repository.getAllProducts());
        return "products";
    }

    @GetMapping("/products/{id}/info")
    public String showCurrentProduct(Model model, @PathVariable long id){
        Product p = repository.getProductById(id);
        model.addAttribute("p", p);
        return "current_product";
    }
}
