package view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import controller.UserController;
import model.User;

public class UserView {
	
	private static final UserController  userController = new UserController();
	
	public boolean userLogin(Scanner userInput) {
		
		Boolean login = false;
		userInput.nextLine();
		System.out.println("\033[1;33m Enter your name \033[0m");
		String name= userInput.nextLine();
		System.out.println("\033[1;33m Enter your email \033[0m");
		String email = userInput.nextLine();
		System.out.println("\033[1;33m Enter your password \033[0m");
		String password = userInput.nextLine();
		
		
		 if(userController.Login(name, email.toLowerCase(), password)) {
			 System.out.print("\033[1;32m Login Success \033[0m");
			 System.out.println();
			 login=true;
		 }else {
			 System.out.println("\033[1;33m There is no such user , you need to register \033[0m");
		 }
		 return login;
	}
	
	public void userRegister(Scanner userInput) {
		userInput.nextLine();
		System.out.println("\033[1;33m Enter your name \033[0m");
		String name= userInput.nextLine();
		System.out.println("\033[1;33m Enter your email \033[0m");
		String email = userInput.nextLine();
		System.out.println("\033[1;33m Enter your password \033[0m");
		String password = userInput.nextLine();
		
		 if(userController.register(name, email.toLowerCase(), password)) {
			 System.out.println("\033[1;32m Successfully Register , Please Login ! \033[0m");
		 }else {
			 System.out.println("\033[1;33m Fail to register \033[0m");
		 }
	}
	
	public void userCreate(Scanner userInput) {
		userInput.nextLine();
		System.out.println("\033[1;33m Enter user name \033[0m");
		String name= userInput.nextLine();
		System.out.println("\033[1;33m Enter user email \033[0m");
		String email = userInput.nextLine();
		System.out.println("\033[1;33m Enter user password \033[0m");
		String password = userInput.nextLine();
		System.out.println("\033[1;33m Enter user Role \033[0m");
		String role = userInput.nextLine();
		
		 if(userController.create(name, email.toLowerCase(), password,role.toLowerCase())) {
			 System.out.println("\033[1;32m Successfully created user \033[0m");
		 }else {
			 System.out.println("\033[1;33m Fail to create user \033[0m");
		 }
	}
	
	public void showAllUser() {
		
		List<User> users = userController.showAllUser();
		Optional<User> optionalUser = Optional.empty();
		
		if(!users.isEmpty()) {
			for(final User u: users) {
				optionalUser = Optional.of(u);
				if(optionalUser.isPresent()) {
					User user = optionalUser.get();
					printUser(user);
				}
			};
		}
		else {
			System.out.println("\033[1;33m There is no users \033[0m");
		}

	}
	
	public void deleteUser(Scanner userInput) {
		System.out.println("\033[1;33m Enter the id of user you want to delete : \033[0m");
		Long id = userInput.nextLong();
		
		if(userController.delete(id)) {
			System.out.println("\033[1;32m Successfully deleted user " + id + "\033[0m");
		}
		else {
			System.out.println("\033[1;33m There is no such user \033[0m");
		}
	}
	
	public void searchUserById(Scanner userInput) {
		
		userInput.nextLine();
		System.out.println("\033[1;33m Enter the user id you want to search : \033[0m");
		Long id = userInput.nextLong();
		if(userController.getUserById(id).isPresent()) {
			User user=userController.getUserById(id).get();
			printUser(user);
		}else {
			System.out.println("\033[1;33m There is no such user \033[0m");
		}
		
	
     } 
	
	public void updateUser(Scanner userInput) {
		System.out.println("\033[1;33m Enter the user Id you want to update : \033[0m");
		Long id = userInput.nextLong();
		Optional<User >optionalUser = userController.getUserById(id);
		
		if(!optionalUser.isPresent()) {
			System.out.println("\033[1;33m There is no such user \033[0m");
			return;
		}
		
		User user = optionalUser.get();
		printUser(user);
		
		while(true) {
			System.out.println("\033[1;33m Update Operations 1.name 2.email 3.password 4.role \033[0m");
			Integer operation = userInput.nextInt();
			switch (operation) {
			case 1 ->{
				System.out.println("\033[1;33m Updating Name \033[0m");
				String name = userInput.next();
				user.setName(name);
			}
			case 2->{
				System.out.println("\033[1;33m Updating email \033[0m");
				String email = userInput.next();
				user.setEmail(email);
	
			}
			
			case 3->{
				System.out.println("\033[1;33m Updating password \033[0m");
				String password = userInput.next();
				user.setPassword(password);
			}
			case 4->{
				System.out.println("\033[1;33m Updating Role \033[0m");
				userInput.nextLine();
				String role = userInput.nextLine();
				user.setRole(role);
			}
			
			default ->
			{
				System.out.println("\033[1;33m Existing from operations \033[0m");
				break;
			}
			}
			
			
			System.out.println("\033[1;33m Do you want to exist updating ? yes/y no/n \033[0m ");
			Character decision = userInput.next().charAt(0);
			if(decision == 'y') {
				break;
			}
		}
		if(userController.update(user)) {
			System.out.println("\033[1;32m User successfully updated \033[0m");
		}else {
			System.out.println("\033[1;33m User fail to update \033[0m");
		}
	}
	
	
	public void clientInfoUpdate(Long id,Scanner userInput) {
		
		Optional<User >optionalUser = userController.getUserById(id);
		
		if(!optionalUser.isPresent()) {
			System.out.println("\033[1;33m There is no such user \033[0m");
			return;
		}
		
		User user = optionalUser.get();
		printUser(user);
		
		while(true) {
			System.out.println("\033[1;33m Update Operations 1.name 2.email 3.password \033[0m");
			Integer operation = userInput.nextInt();
			switch (operation) {
			case 1 ->{
				System.out.println("\033[1;33m Updating Name \033[0m");
				String name = userInput.next();
				user.setName(name);
			}
			case 2->{
				System.out.println("\033[1;33m Updating email \033[0m");
				String email = userInput.next();
				user.setEmail(email);
	
			}
			
			case 3->{
				System.out.println("\033[1;33m Updating password \033[0m");
				String password = userInput.next();
				user.setPassword(password);
			}
			
			default ->
			{
				System.out.println("\033[1;33m Existing from operations \033[0m");
				break;
			}
			}
			
			
			System.out.println("\033[1;33m Do you want to exist updating ? yes/y no/n \033[0m");
			Character decision = userInput.next().charAt(0);
			if(decision == 'y') {
				break;
			}
		}
		if(userController.clientUpdate(user)) {
			System.out.println("\033[1;32m User successfully updated \033[0m");
		}else {
			System.out.println("\033[1;33m User fail to update \033[0m");
		}
	}
	
	
	
	//utility methods
	
		private void printUser(User user) {
			
			System.out.println("\033[1;36m  User id : "+user.getIt() + "\u001B[0m");
			System.out.println("\033[1;36m  User name : "+user.getName()  + "\u001B[0m");
			System.out.println("\033[1;36m  User email: "+user.getEmail()  + "\u001B[0m");
			System.out.println("\033[1;36m  User password : "+user.getPassword()  + "\u001B[0m");
			System.out.println();
		}
		
		
}
