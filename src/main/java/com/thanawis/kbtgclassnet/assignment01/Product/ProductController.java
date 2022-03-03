package com.thanawis.kbtgclassnet.assignment01.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> getAllProducts(){
        return productService.findAll();
    }


    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product getProductById(@PathVariable("id") Long id){
        return productService.findById(id);
    }
}
