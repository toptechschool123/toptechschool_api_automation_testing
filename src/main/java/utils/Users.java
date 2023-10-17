package utils;

public class Users {
	
	private String name;
	private String email;
	private String title;
	private String address;
	
	
	public Users (String name, String email, String title, String address) {
		
		this.name = name;
		this.email=email;
		this.title = title;
		this.address= address;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

}
