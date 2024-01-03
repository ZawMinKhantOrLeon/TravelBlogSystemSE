package entry;

import java.util.Scanner;

import asset.CurrentUserSession;
import view.PostView;
import view.UserView;


public class entry {
	
	private static final PostView postView = new PostView();
	private static final UserView userView = new UserView();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userInput = new Scanner(System.in);
		start(userInput);
	
	}
	
	private static void start(Scanner userInput){
		while(true) {
			
			System.out.println("1.Login 2.Register");
			Integer operations = userInput.nextInt();
			
				switch (operations) {
				case 1 ->{
					Boolean login=userView.userLogin(userInput);
					
					if(login) {
						System.out.println("Welcome from travel blog ");
						if(CurrentUserSession.getRole().equals("admin")) {
							adminCreation(userInput);
						}
						else {
							creation(userInput);
						}
					}
				}
				case 2->{
					userView.userRegister(userInput);
					
				}
				default ->
				throw new IllegalArgumentException("Unexpected value: " + operations);
				};
				
				System.out.println("Do you want to exist from program? yes/y no/n");
				Character decision = userInput.next().charAt(0);
				if(decision == 'y') {
					userInput.close();
					break;
				}
			}
	}
	
	private static void creation(Scanner userInput) {
		while(true) {
			System.out.print("1.Create 2.Show 3.Delete 4.Search 5.Update 6.Exist");
			
			Integer postOperations = userInput.nextInt();
			
			switch (postOperations) {
			case 1 ->{
			
				postView.create(userInput);
			}
			
			case 2 ->{
				
				postView.showAll();
			}
			
			case 3->{
				
				postView.delete(userInput);
			}
			
			case 4 ->{
				postView.searchPostByTitle(userInput);
			}
			
			case 5->{
				postView.update(userInput);
			}
			case 6 ->{
				break;
			}
			default ->
			throw new IllegalArgumentException("Unexpected value: " + postOperations);
			}
			
		}
	}
	
	private static void adminCreation(Scanner userInput) {
		while(true) {
			System.out.println("Your Role is Admin So You can \n1.Monitor User 2.Create Posts");
			Integer adminDecision = userInput.nextInt();
			
			switch (adminDecision) {
			case 1 ->{
				while(true) {
					System.out.println("1.Show 2.Create 3.Delete 4.Update");
					Integer adminUserOperation= userInput.nextInt();
					
					switch (adminUserOperation) {
					case 1 ->{
						userView.showAllUser();
					}
					case 2->{
						
					}
					
					case 3->{
						userView.deleteUser(userInput);
					}
					case 4 ->{
						userView.updateUser(userInput);
					}
					default ->
					throw new IllegalArgumentException("Unexpected value: " + adminUserOperation);
					}
					
					System.out.println("Admin Do you want to exist from user panel ? yes/y no/n ");
					Character existDecision = userInput.next().charAt(0);
					if(existDecision == 'y') {
						break;
					}
				}
			}
			case 2->{
				creation(userInput);
			}

			default ->
			throw new IllegalArgumentException("Unexpected value: " + adminDecision);
			}
			System.out.println("Admin Do you want to exist from admin panel ? yes/y no/n ");
			Character existDecision = userInput.next().charAt(0);
			if(existDecision == 'y') {
				break;
			}
			
		}
	}

}
