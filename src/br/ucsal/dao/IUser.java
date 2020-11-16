package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.UserModel;

public interface IUser {
	public boolean insert(UserModel book, List<UserModel> listUsers);
	
	public List<UserModel> toList();
	
	public boolean update(String register, String passwordOld, String newPassword, List<UserModel> listUsers);
	
	public boolean remove(String register, List<UserModel> listUsers);
}
