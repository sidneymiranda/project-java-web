package br.ucsal.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1197854600440771580L;
	private String name;
	private String register;
	private String password;
	private String typeUser;

	public User() {
		
	}
	public User(String name, String register, String password, String typeUser) {
		this.name = name;
		this.register = register;
		this.password = password;
		this.typeUser = typeUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

}
