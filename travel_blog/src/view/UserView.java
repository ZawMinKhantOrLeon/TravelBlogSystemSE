package view;

import java.util.Scanner;

import controller.UserController;

public class UserView {
	
	
	public boolean userLogin(Scanner userInput) {
		Boolean login = false;
		System.out.println("Enter your name");
		String name= userInput.nextLine();
		userInput.nextLine();
		System.out.println("Enter your email");
		String email = userInput.nextLine();
		System.out.println("Enter your password");
		String password = userInput.nextLine();
		
		UserController  userController = new UserController();
		 if(userController.Login(name, email, password)) {
			 System.out.print("Login Success ");
			 login=true;
		 }else {
			 System.out.println("There is no such user , you need to register");
		 }
		 return login;
	}
	
	public void userRegister(Scanner userInput) {
		userInput.nextLine();
		System.out.println("Enter your name");
		String name= userInput.nextLine();
		System.out.println("Enter your email");
		String email = userInput.nextLine();
		System.out.println("Enter your password");
		String password = userInput.nextLine();
		
		UserController  userController = new UserController();
		
		 if(userController.register(name, email, password)) {
			 System.out.println("Successfully Register");
		 }else {
			 System.out.println("Fail to register");
		 }
	}
	
//	public Boolean create(Scanner userInput) {
//		
//		System.out.println("Enter Your Name");
//		String name = userInput.next();
//		System.out.println("Enter Your Email");
//		String email = userInput.next();
//		System.out.println("Enter Your Password");
//		String password = userInput.next();
//		
//		User user = new User(name,email,password);
//		
//		UserController userController =new UserController();
//		return userController.create(user);
//		
//	}
}