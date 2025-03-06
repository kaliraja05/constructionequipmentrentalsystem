package com.construction.dao;

import org.springframework.stereotype.Service;

import com.construction.model.Admin;
@Service
public interface AdminDao {
	public boolean saveAdmin(Admin admin);
	public int validate(Admin login);
}