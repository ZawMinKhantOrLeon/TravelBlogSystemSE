package view;

import java.util.List;
import java.util.Scanner;

import controller.UserController;
import model.User;

public class UserView {
	
	private static final UserController  userController = new UserController();
	
	public boolean userLogin(Scanner userInput) {
		Boolean login = false;
		userInput.nextLine();
		System.out.println("Enter your name");
		String name= userInput.nextLine();
		System.out.println("Enter your email");
		String email = userInput.nextLine();
		System.out.println("Enter your password");
		String password = userInput.nextLine();
		
		
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
		
		
		 if(userController.register(name, email, password)) {
			 System.out.println("Successfully Register");
		 }else {
			 System.out.println("Fail to register");
		 }
	}
	
	public void showAllUser() {
		
		List<User> users = userController.showAllUser();
		checkEmpty(users);
	}
	
	public void deleteUser(Scanner userInput) {
		System.out.println("Enter the id of user you want to delete :");
		Long id = userInput.nextLong();
		
		if(userController.delete(id)) {
			System.out.println("Successfully deleted user " + id);
		}
		else {
			System.out.println("There is no such user");
		}
	}
	
	public void updateUser(Scanner userInput) {
		System.out.println("Enter the user Id you want to update : ");
		Long id = userInput.nextLong();
		User user = userController.getUserById(id);
		
		if(user.getIt() == null) {
			System.out.println("There is no such user");
			return;
		}
		showUser(user);
		
		while(true) {
			System.out.println("1.name 2.email 3.password");
			Integer operation = userInput.nextInt();
			switch (operation) {
			case 1 ->{
				System.out.println("Updating Name");
				String name = userInput.next();
				user.setName(name);
			}
			case 2->{
				System.out.println("Updating email");
				String email = userInput.next();
				user.setEmail(email);
	
			}
			
			case 3->{
				System.out.println("Updating password");
				userInput.nextLine();
				String password = userInput.nextLine();
				user.setPassword(password);
			}
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + operation);
			}
			
			
			System.out.println("Do you want to exist updating ? yes/y no/n ");
			Character decision = userInput.next().charAt(0);
			if(decision == 'y') {
				break;
			}
		}
		if(userController.update(user)) {
			System.out.println("User successfully updated");
		}else {
			System.out.println("User fail to update");
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
	
	//utility methods
	
		private void showUser(User user) {
			System.out.println("User id : "+user.getIt());
			System.out.println("User name : "+user.getName());
			System.out.println("User email: "+user.getEmail());
			System.out.println("User password : "+user.getPassword());
		}
		
		private void checkEmpty(List<User> users) {
			
			if(!users.isEmpty()) {
				users.forEach((u)->{
					showUser(u);
				});
			}
			else {
				System.out.println("There is no users");
			}
		}
}
