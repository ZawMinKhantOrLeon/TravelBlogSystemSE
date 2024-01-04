package model;

public class Agent {
	
	private Long id;
	private String name;
	private String phone;
	private String email;
	private Boolean active;
	
	public Agent() {
		
	}

	public Agent(Long id, String name, String phone, String email, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.active = active;
	}

	public Agent(String name, String phone, String email, Boolean active) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", active=" + active
				+ "]";
	}
	
	
}