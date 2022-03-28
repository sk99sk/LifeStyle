package com.fastenal.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastenal.spring.model.ProductList;
import com.fastenal.spring.model.Product;
import com.fastenal.spring.service.ProductService;

@RestController
public class ProductsRESTController {

	@Autowired(required = true)
	@Qualifier(value = "productService")
	private ProductService productService;


	@RequestMapping(value = "/products-json", method = RequestMethod.GET)
	public ProductList getAllProducts() {
		List<Product> products = new ArrayList<>();
		products = this.productService.listProducts();
		ProductList productlist = new ProductList(products);
		return productlist;
	}



}
