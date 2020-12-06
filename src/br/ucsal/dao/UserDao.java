package br.ucsal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.User;

@SuppressWarnings("unchecked")
public class UserDao implements IUser {
	private static boolean response = false;
	private static List<User> listUsers;
	
	
	private static User addAdmin() {
		User admin = new User();
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setRegister("admin");
		admin.setTypeUser("admin");
		
		return admin;
	}

	private List<User> getUsers(HttpSession session) {
		listUsers = (List<User>) session.getAttribute("listUsers") == null ? new ArrayList<>()
				: (List<User>) session.getAttribute("listUsers");

		return listUsers;
	}

	@Override
	public void insert(User user, HttpSession session) {
		try {
			listUsers = getUsers(session);
			if (listUsers.isEmpty()) {
				listUsers.add(addAdmin());
			}

			listUsers.add(user);
			session.setAttribute("listUsers", listUsers);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> toList() {
		return null;
	}

	@Override
	public boolean update(User user, HttpSession session) {
		listUsers = getUsers(session);
		try {
			if (!listUsers.isEmpty()) {
				listUsers.forEach(u -> {
					if (u.getRegister().equals(user.getRegister())) {
						u.setName(user.getName());
						u.setTypeUser(user.getTypeUser());

						session.setAttribute("listUsers", listUsers);
					}
				});
				return true;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void remove(User user, HttpSession session) {
		listUsers = getUsers(session);
		if (!listUsers.isEmpty()) {
			listUsers.forEach(u -> {
				if (u.getRegister().equals(user.getRegister())) {
					listUsers.remove(u);
				}
			});
		}
	}

	public boolean exists(String register, String password, HttpSession session) {
		listUsers = getUsers(session);

		if (!listUsers.isEmpty() && listUsers != null) {
			listUsers.forEach(user -> {
				if (user.getRegister() != null && user.getPassword() != null && user.getRegister().equals(register)
						&& user.getPassword().equals(password)) {
					session.setAttribute("userLogado", user.getName());
					session.setAttribute("profile", user.getTypeUser());
					response = true;
				}
			});
		}
		return response;
	}

	public boolean logged(HttpSession session) {
		boolean logged = false;
		String user = (String) session.getAttribute("userLogado");
		if(user != null) {
			
		}
		return true;
	}
	
}
