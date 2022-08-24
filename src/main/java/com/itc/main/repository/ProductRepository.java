package com.itc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itc.main.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//T  : It is domain type that repository manages like Entity/Model class name
//ID :  Type of id of the entity that repository manages
	//Own methods inside the 
	Product getProductByPname(String name);
	
	//Native Query
	@Query(value = "select * from product",nativeQuery = true)
	List<Product> getProducts();
	
	
}
