package com.example.page.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.page.model.Product;
import com.example.page.repo.ProductRepo;

@Service
public class ProductService {

	
	  @Autowired
	  private ProductRepo pr;
//	  @PostConstruct
//	  public void initDB() {
//		  
//		  List<Product> products = IntStream.rangeClosed(1, 200).mapToObj(i -> new Product(i, "product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//		 .collect(Collectors.toList());	
//		  pr.saveAll(products);
//	  }
	  
	  public List<Product> findAllProducts(){
		    return pr.findAll();
	  }
	  
	  public List<Product> findProductWithSorting(String field){
		  return pr.findAll(Sort.by(Sort.Direction.ASC,field));
	  }
	  
	  public Page<Product> findProductsWithPagination(int offset,int pageSize){
		  Page<Product> products = pr.findAll(PageRequest.of(offset, pageSize));
	      	return products;
	  }
	  
	  public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
		  Page<Product> products = pr.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	      	return products;
	  }
}
