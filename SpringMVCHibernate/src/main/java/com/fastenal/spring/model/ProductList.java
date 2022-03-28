package com.fastenal.spring.model;

import java.util.ArrayList;
import java.util.List;

import com.fastenal.spring.model.Product;

public class ProductList {
	
	private List<Product> products;
	
	public ProductList() {
		this.products = new ArrayList();
	}

	@Override
	public String toString() {
		return "ProductList [products=" + products + "]";
	}

	public ProductList(List<Product> productList) {
		super();
		this.products = productList;
	}

	public List<Product> getProductList() {
		return products;
	}

	public void setProductList(List<Product> productList) {
		this.products = productList;
	}
	
	public void addProductTolist(Product product) {
		this.products.add(product);
	}
	

}
