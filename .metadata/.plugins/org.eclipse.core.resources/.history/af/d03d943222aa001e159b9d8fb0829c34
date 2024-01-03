package controller;

import model.User;
import model.UserModel;


public class UserController {
	
	private void storeSessionId(User user) {
		UserModel userModel = new UserModel();
		userModel.getUserInfo(user);
	}
	
	public Boolean Login(String name,String email,String password) {
		UserModel userModel = new UserModel();
		User user = new User(name,email,password);
		storeSessionId(user);
		return userModel.login(user);
	}
	public Boolean register(String name,String email,String password) {
		UserModel userModel = new UserModel();
		User user = new User(name,email,password);
		return userModel.register(user);
	}
}
