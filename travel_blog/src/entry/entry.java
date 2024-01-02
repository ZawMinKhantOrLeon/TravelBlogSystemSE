package entry;

import java.util.Scanner;

import controller.UserController;
import view.PostView;
import view.UserView;


public class entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final UserView userView= new UserView();
		Scanner userInput = new Scanner(System.in);
		
		while(true) {
			
		System.out.println("1.Login 2.Register");
		Integer operations = userInput.nextInt();
		
			switch (operations) {
			case 1 ->{
				Boolean login=userView.userLogin(userInput);
				
				if(login) {
					System.out.println("Welcome from travel blog ");
					while(true) {
						System.out.print("1.Create 2.Show 3.Delete 4.Update");
						Integer postOperations = userInput.nextInt();
						
						switch (postOperations) {
						case 1 ->{
							PostView postView = new PostView();
							postView.create(userInput);
						}
						
						default ->
						throw new IllegalArgumentException("Unexpected value: " + postOperations);
						}
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

}