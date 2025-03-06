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

import com.construction.model.User;

@Component
public  class UserDaoImpl implements UserDao {
	 
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
	private DataSource datasource;
	
    
    @Override
	public boolean saveUser(User nuser) {
		// TODO Auto-generated method stub
    	boolean status = false;
		String query = "insert into user(fname,lname,uname,dob,gender,phoneno,email,password) values(?,?,?,?,?,?,?,?)";
		Object[] args = new Object[] { nuser.getFname(), nuser.getLname(), nuser.getUname(), nuser.getDob(), nuser.getGender(), nuser.getPhoneno(), nuser.getEmail(), nuser.getPassword() };

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
	public int validate(User login) {
		List<User> uList = new ArrayList<User>();
		String sql = "select * from user where uname=? and password=?";
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql, login.getUname(), login.getPassword());
		for (Map<String, Object> i : userList) {
			User user = new User();

			user.setUname((String) i.get("uname"));
			user.setPassword((String) i.get("password"));

			uList.add(user);
			// Checking Purpose
			// System.out.println(user);
		}

		return uList.size() > 0 ? 1 : 0;
	}
    
    @SuppressWarnings("deprecation")
	@Override
    public User getUserByName(String uname){    
        String sql="select * from user where uname=?";    
        return jdbcTemplate.queryForObject(sql, new Object[]{uname},new BeanPropertyRowMapper<User>(User.class));    
    }
    @Override
    public int changePassword(User unpass){    
        String sql="update user set password='"+unpass.getPassword()+"' where uname='"+unpass.getUname()+"'";    
        return jdbcTemplate.update(sql);    
    }
    
    @Override
    public int update(User user){    
        String sql="update user set fname='"+user.getFname()+"', lname='"+user.getLname()+"',dob='"+user.getDob()+"',gender='"+user.getGender()+"',phoneno='"+user.getPhoneno()+"',email='"+user.getEmail()+"' where u_id="+user.getU_id()+"";    
        return jdbcTemplate.update(sql);    
    }
    @Override
    public int delete(int u_id){    
        String sql="delete from user where u_id="+u_id+"";    
        return jdbcTemplate.update(sql);    
    }   
    
    @SuppressWarnings("deprecation")
	@Override
    public User getUserById(int u_id){    
        String sql="select * from user where u_id=?";    
        return jdbcTemplate.queryForObject(sql, new Object[]{u_id},new BeanPropertyRowMapper<User>(User.class));    
    }  
    @Override
    public List<User> getUser(){    
        return jdbcTemplate.query("select * from user",new RowMapper<User>(){    
            public User mapRow(ResultSet rs, int row) throws SQLException {    
                User user =new User();    
                user.setU_id(rs.getInt(1));    
                user.setFname(rs.getString(2));    
                user.setLname(rs.getString(3));    
                user.setUname(rs.getString(4));   
                user.setDob(rs.getString(5));
                user.setGender(rs.getString(6));
                user.setPhoneno(rs.getString(7));
                user.setEmail(rs.getString(8));
                return user;    
            }    
        });    
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

   

  	
}
