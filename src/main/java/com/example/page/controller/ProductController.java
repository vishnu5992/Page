package com.example.page.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.APIResponse;
import com.example.page.model.Product;
import com.example.page.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
    
	@Autowired
	 private  ProductService ps;
	
   @GetMapping
   private List<Product> getProducts(){
	   List<Product> allProducts = ps.findAllProducts();
	   return allProducts;
   }
//   
    @GetMapping("/{field}")
     private List<Product> getProductsWithSort(@PathVariable String field){
      List<Product> allProducts = ps.findProductWithSorting(field);
	   return allProducts;
   }   
    
    @GetMapping("/pagination/{offset}/{pageSize}")
    private Page<Product> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
     Page<Product> allProducts = ps.findProductsWithPagination(offset,pageSize);
	   return allProducts;
  }   
    
    @GetMapping("/pagination/{offset}/{pageSize}/{field}")
    private Page<Product> getProductsWithPaginationSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field){
     Page<Product> allProducts = ps.findProductsWithPaginationAndSorting(offset,pageSize,field);
	   return allProducts;
  }   
    
} 