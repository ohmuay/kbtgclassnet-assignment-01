package com.thanawis.kbtgclassnet.assignment01.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<List<Product>> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name,String description);
}
