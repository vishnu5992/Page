package com.example.page.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.page.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
