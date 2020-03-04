package bean;

public class User {
	private String username;
	private String email;
	private String password;
	private String nom;
	private String prenom;
 
	public User() {
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String nom, String prenom, String username, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return  username + "		" + email + "			"+ password ;
	}

	@Override
	public boolean equals(Object obj) {
       if (obj instanceof User) {
    	   User otherUser = (User) obj;
    	   return otherUser.getUsername().equals(username)
   				&& otherUser.getPassword().equals(password);
       }
		
       return false;

	}
}
