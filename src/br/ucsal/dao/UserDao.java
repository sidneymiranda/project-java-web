package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.UserModel;

public class UserDao implements IUser {

	@Override
	public boolean insert(UserModel userModel, List<UserModel> listUsers) {
		try {
			listUsers.add(userModel);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<UserModel> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String register, String passwordOld, String newPassword, List<UserModel> listUsers) {
		for (UserModel userModel : listUsers) {
			if (userModel.getRegister().equals(register) && userModel.getPassword().equals(passwordOld)) {
				userModel.setPassword(newPassword);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(String register, List<UserModel> listUsers) {
		for (UserModel userModel : listUsers) {
			if (userModel.getRegister().equals(register)) {
				listUsers.remove(userModel);
				return true;
			}
		}
		return false;
	}

}
