package com.itc.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Product;
import com.itc.main.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void save(Product product) {
		this.productRepository.save(product);

	}

	public List<Product> getAllProducts() {
		//return this.productRepository.findAll();
		return this.productRepository.getProducts();

	}

	public Product getProductById(int id) {
		Optional<Product> op = this.productRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}

	}

	public List<Product> updateProduct(Product product) {
		if (this.productRepository.existsById(product.getPid())) {
			this.productRepository.save(product);
			return this.productRepository.findAll();
		} else
			return null;
	}

	public boolean deleteProductById(int id) {
		this.productRepository.deleteById(id);

		return true;
	}

	public Product getProductByName(String pname) {
		Product product = this.productRepository.getProductByPname(pname);

		if (product != null)
			return product;
		else
			return null;
	}
	
	 
}
