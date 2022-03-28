package com.fastenal.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastenal.spring.dao.ProductDAO;
import com.fastenal.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional("transactionManagerProduct")
	public void addProduct(Product p) {
		this.productDAO.addProduct(p);
	}

	@Override
	@Transactional("transactionManagerProduct")
	public void updateProduct(Product p) {
		this.productDAO.updateProduct(p);
	}

	@Override
	@Transactional("transactionManagerProduct")
	public List<Product> listProducts() {
		return this.productDAO.listProducts();
	}

	@Override
	@Transactional("transactionManagerProduct")
	public Product getProductById(int id) {
		return this.productDAO.getProductById(id);
	}

	@Override
	@Transactional("transactionManagerProduct")
	public void removeProduct(int id) {
		this.productDAO.removeProduct(id);
	}

}
