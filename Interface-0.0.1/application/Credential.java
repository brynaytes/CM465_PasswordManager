package application;

public class Credential {
	
	private String url;
	private String username;
	private String password;
	
	private Credential(String url, String username, String password)
	{
		this.url = new String(url);
		this.username = new String(username);
		this.password = new String(password);
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
