package com.construction.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.construction.model.Order;
import com.construction.model.Product;

@Component
public class OrderDaoImpl implements OrderDao{
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource datasource;
	
	

	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
		public int saveOrder(Order order) {
			// TODO Auto-generated method stub
			String query = "insert into orders(U_id,p_id,pro_name,quant,time,totalprice,orderDate,delivery,status) values(?,?,?,?,?,?,?,?,?)";
			Object[] args = new Object[] { order.getU_id(), order.getP_id(), order.getPro_name(), order.getQuant(), order.getTime(), order.getTotalprice(), order.getOrderdate(), order.getDelivery(), order.getStatus() };

			return jdbcTemplate.update(query, args);
}

	 @SuppressWarnings("deprecation")
		public Order getOrderById(int u_id){    
	        String sql="select * from constructions.orders where U_id=?";    
	        return jdbcTemplate.queryForObject(sql, new Object[]{u_id},new BeanPropertyRowMapper<Order>(Order.class));    
	    }  
	    public List<Order> getOrder(){    
	        return jdbcTemplate.query("select * from constructions.orders",new RowMapper<Order>(){    
	            public Order mapRow(ResultSet rs, int row) throws SQLException {    
	                Order order =new Order();    
	                order.setOrder_id(rs.getInt(1));        
	                order.setU_id(rs.getInt(2)); 
	                order.setP_id(rs.getInt(3));
	                order.setPro_name(rs.getString(4));   
	                order.setQuant(rs.getInt(5));
	                order.setTime(rs.getInt(6));
	                order.setTotalprice(rs.getInt(7));
	                order.setOrderdate(rs.getString(8));
	                order.setDelivery(rs.getString(9));
	                order.setStatus(rs.getString(10));
	                return order;    
	            }    
	        });    
	    }
		
	    public int updateOrder(Order order){    
	        String sql="update constructions.orders set delivery='"+order.getDelivery()+"', status='"+order.getStatus()+"' where order_id="+order.getOrder_id()+"";    
	        return jdbcTemplate.update(sql);    
	    }
	   
	    @Override
	    public List<Order> getOrdersById(int u_id){    
	    	List<Order> uList = new ArrayList<Order>();
			String query = "select * from constructions.orders where U_id=? ";
			List<Map<String, Object>> orderRows = jdbcTemplate.queryForList(query, new Object[] {u_id});

			for (Map<String, Object> i : orderRows) {
				Order order= new Order();

				        order.setOrder_id((int)i.get("order_id"));        
		                order.setU_id((int)i.get("U_id"));
	                    order.setP_id((int)i.get("p_id"));
		                order.setPro_name((String)i.get("pro_name"));
	                    order.setQuant((int)i.get("quant"));
		                order.setTime((int)i.get("time"));
		                order.setTotalprice((int)i.get("totalprice"));
		                order.setOrderdate((String)i.get("orderDate"));
		                order.setDelivery((String)i.get("delivery"));
		                order.setStatus((String)i.get("status"));
				uList.add(order);
			}

			return uList;
	    }
	    
	    @Override
		public boolean addToOrder(Order order) {
			// TODO Auto-generated method stub
			boolean status = false;
			String query = "insert into constructions.orders(U_id,p_id,pro_name,quant,time,totalprice,orderdate,delivery,status) values(?,?,?,?,?,?,?,?,?)";
			Object[] args = new Object[] { order.getU_id(), order.getP_id(), order.getPro_name(), order.getQuant(), order.getTime(), order.getTotalprice(), order.getOrderdate(), order.getDelivery(), order.getStatus() };

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
	    
	    @Override
	    public int updateQuantity(Product product){    
	        String sql = "update constructions.product set quantity=? where product_id=?";
	     //  String sql="update constructions.product set quantity='"+product.getQuantity()+"' where product_id='"+product.getProduct_id()+"'";    
	        return jdbcTemplate.update(sql,product.getQuantity(),product.getProduct_id());
	    }
	    
	    @Override
	    public int deleteOrder(int order_id){    
	        String sql="delete from orders where order_id="+order_id+"";    
	        return jdbcTemplate.update(sql);    
	    }  

		public DataSource getDatasource() {
			return datasource;
		}



		public void setDatasource(DataSource datasource) {
			this.datasource = datasource;
		}
	    }
