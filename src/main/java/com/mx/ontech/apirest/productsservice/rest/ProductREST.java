package com.mx.ontech.apirest.productsservice.rest;

import com.mx.ontech.apirest.productsservice.dao.ProductsDAO;
import com.mx.ontech.apirest.productsservice.entitys.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductREST {

    @Autowired
    private ProductsDAO productsDAO;

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
       List<Product> products = productsDAO.findAll();
       return ResponseEntity.ok(products);
    }

    @RequestMapping(value="{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
        Optional<Product> optionalProduct = productsDAO.findById(productId);
        if(optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productsDAO.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productsDAO.deleteById(productId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> optionalProduct = productsDAO.findById(product.getId());
        if(optionalProduct.isPresent()) {
            Product updateProduct = optionalProduct.get();
            updateProduct.setName(product.getName());
            productsDAO.save(updateProduct);
            return ResponseEntity.ok(updateProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
