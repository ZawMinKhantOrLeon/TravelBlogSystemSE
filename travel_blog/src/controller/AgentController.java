package controller;

import java.util.List;
import java.util.Optional;

import model.Agent;
import model.AgentModel;



public class AgentController {
	
	private static final AgentModel agentModel = new AgentModel();
	

	public Boolean create(String name,String phone,String email,Boolean active) {
		
		Agent agent = new Agent(name,phone,email,active);
		return  agentModel.createAgent(agent);
	}
	
	public List<Agent> showAllAgent() {
		return agentModel.showAllAgent();
	}
	
	public Optional<Agent> getAgentById(Long id) {
		return agentModel.getAgentById(id);
	}
	
	
	public Boolean delete(Long id) {
		return agentModel.delete(id);
	}
	
	public Boolean update(Agent agent) {
		return agentModel.update(agent);
	}
	
}
