package com.mx.ontech.apirest.productsservice.rest;

import com.mx.ontech.apirest.productsservice.entitys.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ontech.apirest.productsservice.entitys.Product;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductREST {

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
        return null;
    }
}
