package br.ucsal.controller;

import java.util.List;

import br.ucsal.model.User;

public interface IUser {
	public boolean insert(User book, List<User> listUsers);
	
	public List<User> toList();
	
	public boolean update(String register, String passwordOld, String newPassword, List<User> listUsers);
	
	public boolean remove(String register, List<User> listUsers);
}
