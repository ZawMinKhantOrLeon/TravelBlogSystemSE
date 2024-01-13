package session;

public class CurrentUserSession {
	
	static private Long Id;
	static private String Role;
	static private String Name;
	

	
	public CurrentUserSession() {
		
	}


	static public Long getId() {
		return Id;
	}


	static public void setId(Long id) {
		Id = id;
	}
	static public String getRole() {
		return Role;
	}
	static public void setRole(String role) {
			Role = role;
	}


	static public  String getName() {
		return Name;
	}


	static public  void setName(String name) {
		Name = name;
	}

	

	
	
	
	
	
	
}
