package com.construction.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.construction.model.Admin;
@Component
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	@Override
	public boolean saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		boolean status = false;
		String query = "insert into admin(aname,email,password) values(?,?,?)";
		Object[] args = new Object[] { admin.getAname(), admin.getEmail(), admin.getPassword() };

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
	public int validate(Admin login) {
		// TODO Auto-generated method stub
		List<Admin> aList = new ArrayList<Admin>();
		String sql = "select * from admin where aname=? and password=?";
		List<Map<String, Object>> adminList = jdbcTemplate.queryForList(sql, login.getAname(), login.getPassword());
		for (Map<String, Object> i : adminList) {
			Admin admin = new Admin();

			admin.setAname((String) i.get("aname"));
			admin.setPassword((String) i.get("password"));

			aList.add(admin);
			// Checking Purpose
			// System.out.println(user);
		}

		return aList.size() > 0 ? 1 : 0;	
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate2) {
		// TODO Auto-generated method stub
		
	}

}