package br.ucsal.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.UserModel;

public class UserDao implements IUser {
	private static final UserModel ADMIN = new UserModel("admin", "admin", "admin", "admin");
	private static boolean response = false;
	private static List<UserModel> listUsers;

	@SuppressWarnings("unchecked")
	@Override
	public void insert(UserModel user, HttpSession session) {
		try {
			listUsers = (List<UserModel>) session.getAttribute("listUsers") == null ? new ArrayList<UserModel>()
					: listUsers;

			if (listUsers.isEmpty()) {
				listUsers.add(ADMIN);
			}

			listUsers.add(user);
			session.setAttribute("listUsers", listUsers);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserModel> toList() {
		return null;
	}

	@Override
	public boolean update(UserModel userModel, HttpSession session) {

		try {
			listUsers.forEach(user -> {
				if (user.getRegister().equals(userModel.getRegister())) {
					user.setName(userModel.getName());
					user.setTypeUser(userModel.getTypeUser());

					session.setAttribute("listUsers", listUsers);
				}
			});
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void remove(UserModel userModel, HttpSession session) {

		listUsers.forEach(user -> {
			if (user.getRegister().equals(userModel.getRegister())) {
				listUsers.remove(user);
			}
		});
	}

	@Override
	public boolean exists(String register, String password, HttpSession session) {

		if (listUsers != null) {
			listUsers.forEach(user -> {
				if (user.getRegister().equals(register) && user.getPassword().equals(password)) {

					session.setAttribute("userLogado", user.getName());
					session.setAttribute("profile", user.getTypeUser());
					response = true;
				}
			});
		}
		return response;
	}

}
