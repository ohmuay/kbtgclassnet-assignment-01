package com.thanawis.kbtgclassnet.assignment01.Product;

import com.thanawis.kbtgclassnet.assignment01.CustomExceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product findById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent())
            return productOptional.get();
        else
            throw new ResourceNotFoundException(String.format("ProductId : %s not found",productId));
    }

    public List<Product> findAll() {
        Optional<List<Product>> productsOptional = Optional.of(productRepository.findAll());
        if(productsOptional.isPresent())
            return productsOptional.get();
        else
            return null;
    }

    public List<Product> findBySearch(String name,String description){
        Optional<List<Product>> productsOptional = productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(name,description);
        if(productsOptional.isPresent())
            return productsOptional.get();
        else
            return null;

    }
}
