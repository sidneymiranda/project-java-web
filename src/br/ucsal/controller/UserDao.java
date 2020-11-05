package br.ucsal.controller;

import java.util.List;

import br.ucsal.model.User;

public class UserDao implements IUser {

	@Override
	public boolean insert(User user, List<User> listUsers) {
		try {
			listUsers.add(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<User> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String register, String passwordOld, String newPassword, List<User> listUsers) {
		for (User user : listUsers) {
			if (user.getRegister().equals(register) && user.getPassword().equals(passwordOld)) {
				user.setPassword(newPassword);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(String register, List<User> listUsers) {
		for (User user : listUsers) {
			if (user.getRegister().equals(register)) {
				listUsers.remove(user);
				return true;
			}
		}
		return false;
	}

}
