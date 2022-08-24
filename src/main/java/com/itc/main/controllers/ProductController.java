package com.itc.main.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.Product;
import com.itc.main.services.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Handler Methods

	@PostMapping("product")
	@ApiOperation(value = "SAVE-THE-PRODUCT-DETAILS")
	public ResponseEntity<String> save(@RequestBody @Valid Product product) {
		this.productService.save(product);
		return new ResponseEntity<String>("CREATED", HttpStatus.CREATED);
	}

	@GetMapping("products")
	@ApiOperation(value="GET-ALL-PRODUCTS")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = this.productService.getAllProducts();

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@GetMapping("product/{id}")
	@ApiOperation(value="GET-PRODUCT-BY-ID")
	public ResponseEntity getProductById(@PathVariable int id) {
		Product product = this.productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Resource-Not-Found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("product")
	@ApiOperation(value="UPDATE-PRODUCT-BY-ID")
	public ResponseEntity updateProductById(@RequestBody Product product) {
		List<Product> list = this.productService.updateProduct(product);
		if (list != null)
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Resrouce-Not-Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("product/{id}")
	@ApiOperation(value="DELETE-PRODUCT-BY-ID")
	public ResponseEntity deleteProductById(@PathVariable int id) {
		boolean b = this.productService.deleteProductById(id);
		if (b)
			return new ResponseEntity("SUCCESSFULLY DELETE", HttpStatus.OK);
		else
			return new ResponseEntity("Not-Found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("productname/{name}")
	@ApiOperation(value="GET-PRODUCT-BY-NAME")
	public ResponseEntity getProductByName(@PathVariable String name) {

		Product product = this.productService.getProductByName(name);
		if (product != null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<String>("PRODUCT-NOT-FOUND", HttpStatus.NOT_FOUND);
	}
	
	 
}
