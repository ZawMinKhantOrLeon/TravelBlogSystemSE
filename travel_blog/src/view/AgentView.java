package view;

import java.util.List;
import java.util.Scanner;

import controller.AgentController;
import model.Agent;



public class AgentView {
	private static final AgentController agentController = new AgentController();
	public void agentCreate(Scanner userInput) {
		userInput.nextLine();
		System.out.println("Enter agent name");
		String name= userInput.nextLine();
		System.out.println("Enter agent phone");
		String phone = userInput.nextLine();
		System.out.println("Enter agent email");
		String email = userInput.nextLine();
		System.out.println("Enter agent active status ? yes/y or no/n");
		Boolean active = userInput.next().charAt(0) == 'y' ;
		
		 if(agentController.create(name.toLowerCase(),phone,email.toLowerCase(),active)) {
			 System.out.println("Successfully created agent");
		 }else {
			 System.out.println("Fail to create agent");
		 }
	}
	
	 public void showAllAgent() {
			
			List<Agent> agents = agentController.showAllAgent();
			checkEmpty(agents);
		}
		
	 public void deleteAgent(Scanner userInput) {
			System.out.println("Enter the id of agent you want to delete :");
			Long id = userInput.nextLong();
			
			if(agentController.delete(id)) {
				System.out.println("Successfully deleted agent " + id);
			}
			else {
				System.out.println("There is no such agent");
			}
		}
	 
	 
	 public void updateAgent(Scanner userInput) {
			System.out.println("Enter the agent Id you want to update : ");
			Long id = userInput.nextLong();
			Agent agent = agentController.getAgentById(id);
			
			if(agent == null) {
				System.out.println("There is no such agent");
				return;
			}
			showAgent(agent);
			
			while(true) {
				System.out.println("Update Operations 1.name 2.phone 3.email 4.status");
				Integer operation = userInput.nextInt();
				switch (operation) {
				case 1 ->{
					System.out.println("Updating Name");
					String name = userInput.next();
					agent.setName(name);
				}
				case 2->{
					System.out.println("Updating phone");
					String phone = userInput.next();
					agent.setPhone(phone);
		
				}
				
				case 3->{
					System.out.println("Updating email");
					String email = userInput.nextLine();
					agent.setEmail(email);
				}
				case 4->{
					System.out.println("Updating status");
					userInput.nextLine();
					Boolean status = userInput.next().charAt(0) == 'y';
					agent.setActive(status);
				}
				
				default ->
				{
					System.out.println("Existing System");
					break;
				}
				}
				
				
				System.out.println("Do you want to exist updating ? yes/y no/n ");
				Character decision = userInput.next().charAt(0);
				if(decision == 'y') {
					break;
				}
			}
			if(agentController.update(agent)) {
				System.out.println("User successfully updated");
			}else {
				System.out.println("User fail to update");
			}
		}
	 
	 public void searchAgentById(Scanner userInput) {
			
			userInput.nextLine();
			System.out.println("Enter the agent id you want to search : ");
			Long id = userInput.nextLong();
			Agent agent=agentController.getAgentById(id);
			showAgent(agent);
		
	 } 
	
	
	//utility methods
	
	private void showAgent(Agent agent) {
		
		if(agent != null) {
			System.out.println("Agent id : "+agent.getId());
			System.out.println("Agent name : "+agent.getName());
			System.out.println("Agent phone: "+agent.getPhone());
			System.out.println("Agent email : "+agent.getEmail());
			System.out.println(agent.getActive() ? "Status : Agent is Available " : "Status : Not Available");
		}
		else {
			System.out.println("There is no such agent");
		}
	}
	
	private void checkEmpty(List<Agent> agents) {
		
		if(!agents.isEmpty()) {
			agents.forEach((a)->{
				showAgent(a);
			});
		}
		else {
			System.out.println("There is no agents");
		}
	}
	
}
