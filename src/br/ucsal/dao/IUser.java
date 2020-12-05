package br.ucsal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.User;

public interface IUser {
	
	
	public void insert(User user, HttpSession session);
	
	public List<User> toList();
	
	public boolean update(User user, HttpSession session);
	
	public void remove(User user, HttpSession session);
	
	public boolean exists(String register, String password, HttpSession session);
}
