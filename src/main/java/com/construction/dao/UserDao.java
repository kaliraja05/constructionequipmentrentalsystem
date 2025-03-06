package com.construction.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.construction.model.User;

@Service
public interface UserDao {
	public boolean saveUser(User nuser);
	public int validate(User login);
	public int update(User user);
	public int delete(int u_id);
    public User getUserById(int u_id);
    public List<User> getUser();
	public User getUserByName(String uname);
	public int changePassword(User unpass);
}
