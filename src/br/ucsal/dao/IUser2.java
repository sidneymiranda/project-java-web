package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.User;

public interface IUser2 {

	public void insert(User user);

	public List<User> getList();
	
	public void update(User user);
	
	public int remove(Long id);
}
