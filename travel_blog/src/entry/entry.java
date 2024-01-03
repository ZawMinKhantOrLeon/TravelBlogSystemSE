package entry;

import java.util.Scanner;
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
						creation(userInput);
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
			case 6 ->{
				break;
			}
			default ->
			throw new IllegalArgumentException("Unexpected value: " + postOperations);
			}
			
		}
	}

}
