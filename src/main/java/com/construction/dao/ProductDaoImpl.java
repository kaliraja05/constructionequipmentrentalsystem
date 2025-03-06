package com.construction.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.construction.model.Order;
import com.construction.model.Product;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * @Override public Product getProductById(int product_id) { String
	 * sql="select * from product where product_id=?"; return
	 * jdbcTemplate.queryForObject(sql, new Object[]{product_id},new
	 * BeanPropertyRowMapper<Product>(Product.class)); }
	 */
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from product",new RowMapper<Product>(){    
            public Product mapRow(ResultSet rs, int row) throws SQLException {    
                Product product =new Product();    
                product.setProduct_id(rs.getInt(1));    
                product.setPname(rs.getString(2));    
                product.setQuantity(rs.getInt(3));    
                product.setPriceperhr(rs.getInt(4));   
                return product;    
            }    
        });
	}
    
	@SuppressWarnings("deprecation")
	public Product getProductById(int product_id) {
        String sql="select * from product where product_id=?";    
        return jdbcTemplate.queryForObject(sql, new Object[]{product_id},new BeanPropertyRowMapper<Product>(Product.class));
		}
	
	@Override
	public Blob getImage(int productId) {
		// TODO Auto-generated method stub
		
		String query = "select pimage from product where product_id=?";

		@SuppressWarnings("deprecation")
		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { productId }, Blob.class);

		return photo;
	}

	@Override
	public boolean addproduct(Product product) {

		boolean status = false;
		String query = "insert into product(pname,quantity,priceperhr,pimage) values(?,?,?,?)";
		Object[] args = new Object[] { product.getPname(), product.getQuantity(), product.getPriceperhr(), product.getPimage() };

		int out = jdbcTemplate.update(query, args);
		if(out>0)
		{
			status=true;
		}
		else {
			status=false;
		}
		return status;
	}
	
	
	public List<Product> getProduct(){    
        return jdbcTemplate.query("select * from constructions.orders",new RowMapper<Product>(){    
            public Product mapRow(ResultSet rs, int row) throws SQLException {    
                Product product =new Product();    
                product.setProduct_id(rs.getInt(1));        
                product.setPname(rs.getString(2)); 
                product.setQuantity(rs.getInt(3));
                product.setPriceperhr(rs.getInt(4));   
                return product;    
            }    
        });    
    }
	
	 @Override
	    public int deleteProduct(int product_id){    
	        String sql="delete from product where product_id="+product_id+"";    
	        return jdbcTemplate.update(sql);    
	    }   
	 
	 @Override
		public int updateProduct(Product product) {
			// TODO Auto-generated method stub
		        String sql="update constructions.product set pname='"+product.getPname()+"', quantity='"+product.getQuantity()+"', priceperhr='"+product.getPriceperhr()+"' where product_id="+product.getProduct_id()+"";    
		        return jdbcTemplate.update(sql);    
		    }


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate2) {
		// TODO Auto-generated method stub
		
	}
		
}