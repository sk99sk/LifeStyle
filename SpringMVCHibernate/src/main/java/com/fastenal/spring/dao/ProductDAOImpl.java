package com.fastenal.spring.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fastenal.spring.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addProduct(Product product) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(product);
			logger.info("Product saved successfully, Product Details=" + product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in adding product");
		}

	}

	@Override
	public void updateProduct(Product product) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(product);
			logger.info("Product updated successfully, Product Details=" + product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in adding product");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Product> productsList = session.createQuery("from Product").list();
			logger.info("ProductDAOImpl :: listProducts " + productsList.toString());
			return productsList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error ProductDaoImpl :: listProducts");
			return null;
		}

	}

	@Override
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		if (Objects.isNull(id)) {
			logger.error("ProductDAOImpl :: getProductById :: ID is null");
		}

		Product product = (Product) session.get(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details=" + product);
		return product;

	}

	@Override
	public void removeProduct(int id) {
		if (Objects.isNull(id)) {
			logger.error("ProductDaoImplementation :: removeProduct :: ID of product is null");
			
		}
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		if (null != product) {
			session.delete(product);
		}
		logger.info("Product deleted successfully, product details=" + product);
	}

}
