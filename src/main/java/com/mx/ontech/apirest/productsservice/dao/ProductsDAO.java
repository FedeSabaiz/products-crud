package com.mx.ontech.apirest.productsservice.dao;

import com.mx.ontech.apirest.productsservice.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDAO extends JpaRepository<Product, Long> {
}
