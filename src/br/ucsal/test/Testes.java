package br.ucsal.test;

import br.ucsal.dao.UserDao2;
import br.ucsal.model.User;

public class Testes {

	public static void main(String[] args) {
		
		User u = new User();
		u.setName("sidney");
		UserDao2 dao = new UserDao2();
		System.out.println(dao.validate("sidney"));
		
		
//		GET LIST OK
//		List<User> list = dao.getList();
//		list.forEach(u -> {
//			System.out.println("Nome "+u.getName());
//		});		
		
//		INSERT OK
//		User u = new User();
//		u.setName("sidney");
//		u.setPassword("1000");
//		u.setRegister("1000");
//		u.setTypeUser("admin");
//		dao.insert(u);
	}

}
