package asset;

public class CurrentUserSession {
	
	static private Long Id;
	static private String Role;

	
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
	
	
	
	
}
