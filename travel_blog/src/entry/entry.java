package entry;

import java.util.Scanner;

import session.CurrentUserSession;
import view.AgentView;
import view.PostView;
import view.UserView;


public class entry {
	
	private static final PostView postView = new PostView();
	private static final UserView userView = new UserView();
	private static final AgentView agentView = new AgentView();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userInput = new Scanner(System.in);
		start(userInput);
	
	}
	
	private static void start(Scanner userInput){
		while(true) {
			
			System.out.println("\033[1;32m 1.Login 2.Register 3.Selecting Others will exist the programm \033[0m");
			Integer operations = userInput.nextInt();
			
				switch (operations) {
				case 1 ->{
					Boolean login=userView.userLogin(userInput);
					
					if(login) {
						
						System.out.println("\033[1;33m Welcome from travel blog \033[0m");
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
				{
					System.out.println("\033[1;33m Existing From Operations \033[0m");
					break;
				}
				};
				
				System.out.println("\033[1;33m Do you want to terminate the program? yes/y no/n \033[0m");
				Character decision = userInput.next().charAt(0);
				if(decision == 'y') {
					userInput.close();
					System.out.println("\033[1;32m System closed \033[0m");
					break;
				}
			}
	}
	
	private static void creation(Scanner userInput) {
		while(true) {
			System.out.print("\033[1;33m 1.Create 2.Show 3.Delete 4.Search 5.Update 6.Get into contact with Agents 7.update info \033[0m");
			
			
			Integer postOperations = userInput.nextInt();
			
			switch (postOperations) {
			
			case 1->postView.create(userInput);
			case 2->postView.showAll();
			case 3->postView.delete(userInput);
			case 4->postView.searchPostByTitle(userInput);		
			case 5->postView.update(userInput);
			case 6->agentView.showAllAgent();
			case 7->userView.clientInfoUpdate(CurrentUserSession.getId(), userInput);
			default ->
			{	
				
				System.out.println("\033[1;33m Existing From Operations \033[0m");
				break;
			}
			
			}
			
			System.out.println("\033[1;33m Do you want to exist from post  panel ? yes/y no/n \033[0m");
			Character existDecision = userInput.next().charAt(0);
			if(existDecision == 'y') {
				break;
			}
			
		}
	}
	
	private static void agentCreation(Scanner userInput) {
		while(true) {
			System.out.print("\033[1;33m 1.Create 2.Show 3.Delete 4.Search 5.Update \033[0m");
			Integer postOperations = userInput.nextInt();
			
			switch (postOperations) {
			case 1->agentView.agentCreate(userInput);
			case 2->agentView.showAllAgent();
			case 3->agentView.deleteAgent(userInput);
			case 4->agentView.searchAgentById(userInput);
			case 5->agentView.updateAgent(userInput);
			
			default ->
			{
				System.out.println("\033[1;33m Existing From Operations ######");
				break;
			}
			
			}
			System.out.print("\033[1;33m Do you want to exist from agent panel ? yes/y no/n \033[0m");
			Character existDecision = userInput.next().charAt(0);
			if(existDecision == 'y') {
				break;
			}
			
		}
	}
	
	private static void adminCreation(Scanner userInput) {
		while(true) {
			System.out.println("\033[1;33m Your Role is Admin So You can \n1.Monitor User 2.Create Posts 3.Create Agents \033[0m");
			Integer adminDecision = userInput.nextInt();
			
			switch (adminDecision) {
			case 1 ->{
				while(true) {
					System.out.println("\033[1;33m 1.Show 2.Create 3.Delete 4.Search 5.Update \033[0m");
					Integer adminUserOperation= userInput.nextInt();
					
					switch (adminUserOperation) {
					
					case 1 ->userView.showAllUser();
					case 2->userView.userCreate(userInput);
					case 3->userView.deleteUser(userInput);
					case 4 ->userView.searchUserById(userInput);
					case 5 ->userView.updateUser(userInput);
					
					default ->{
						System.out.println("\033[1;33m Existing From Operations \033[0m");
						break;
					}
					}
					
					System.out.println("\033[1;33m Admin Do you want to exist from user panel ? yes/y no/n \033[0m");
					Character existDecision = userInput.next().charAt(0);
					if(existDecision == 'y') {
						break;
					}
				}
			}
			case 2->creation(userInput);
			case 3 ->agentCreation(userInput);

			default ->
			{
				System.out.println("\033[1;33m Existing From Operations ######");
				break;
			}
			}
			System.out.println("\033[1;33m Admin Do you want to exist from admin panel ? yes/y no/n \033[0m");
			Character existDecision = userInput.next().charAt(0);
			if(existDecision == 'y') {
				break;
			}
			
		}
	}

}
