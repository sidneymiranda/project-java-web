package br.ucsal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.UserModel;

public interface IUser {
	
	
	public void insert(UserModel user, HttpSession session);
	
	public List<UserModel> toList();
	
	public boolean update(UserModel user, HttpSession session);
	
	public void remove(UserModel userModel, HttpSession session);
	
	public boolean exists(String register, String password, HttpSession session);
}
