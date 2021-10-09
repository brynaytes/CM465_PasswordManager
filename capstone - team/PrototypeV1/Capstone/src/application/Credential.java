package application;

import javafx.beans.property.SimpleStringProperty;

public class Credential {
	
	private SimpleStringProperty url;
	private SimpleStringProperty username;
	private SimpleStringProperty password;
	
	Credential(String url, String username, String password)
	{
		this.url = new SimpleStringProperty(url);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
	}
	
	public String getUrl() {
		return url.get();
	}
	
	public void setUrl(String url){
		this.url.set(url);
	}
	
	public String getUsername() {
		return username.get();
	}
	
	public void setUsername(String username) {
		this.username.set(username);
	}
	
	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String password) {
		this.password.set(password);
	}

}
