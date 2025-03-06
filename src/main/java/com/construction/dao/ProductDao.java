package com.construction.dao;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Service;

import com.construction.model.Product;

@Service
public interface ProductDao {
	
	public boolean addProduct(Product product);
	public int deleteProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
	public Blob getImage(int productId);
	public boolean addproduct(Product product);
	List<Product> getProduct();
	public int deleteProduct(int product_id);
	public int updateProduct(Product product);
}
