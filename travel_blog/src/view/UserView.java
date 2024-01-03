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
		
		
		 if(userController.Login(name.toLowerCase(), email.toLowerCase(), password.toLowerCase())) {
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
	
	public void userCreate(Scanner userInput) {
		userInput.nextLine();
		System.out.println("Enter your name");
		String name= userInput.nextLine();
		System.out.println("Enter your email");
		String email = userInput.nextLine();
		System.out.println("Enter your password");
		String password = userInput.nextLine();
		System.out.println("Enter your Role");
		String role = userInput.nextLine();
		
		 if(userController.create(name.toLowerCase(), email.toLowerCase(), password.toLowerCase(),role.toLowerCase())) {
			 System.out.println("Successfully created user");
		 }else {
			 System.out.println("Fail to create user");
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
		
		if(user == null) {
			System.out.println("There is no such user");
			return;
		}
		showUser(user);
		
		while(true) {
			System.out.println("1.name 2.email 3.password 4.role");
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
				String password = userInput.nextLine();
				user.setPassword(password);
			}
			case 4->{
				System.out.println("Updating Role");
				userInput.nextLine();
				String role = userInput.nextLine();
				user.setRole(role);
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
