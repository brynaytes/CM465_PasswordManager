package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private TextField txt_password;
	@FXML
	private TextField txt_username;
	@FXML
	private TextField txt_URL;
	@FXML
	private TextField txt_passwordgen;
	
    public void onClick_btn_ViewCredentials(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/CredentialsTableView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);;
    	window.show();
    }
    
    public void onClick_btn_PasswordGenerator(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/PasswordGenerator.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	window.show();
    }
    
	public void onClick_btn_StoreCredentials(ActionEvent event) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(txt_URL.getText().toString() + "\n");
		sb.append(txt_username.getText().toString() + "\n");
		sb.append(txt_password.getText().toString() + "\n\n");
		
		File file = new File("PasswordFile-PleaseDontRead.txt");
		PrintWriter W = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		W.write(sb.toString());
		W.close();
		
		txt_URL.clear();
		txt_username.clear();
		txt_password.clear();
	}
	
	
	public void onClick_btn_Exit(ActionEvent event) {
		System.exit(0);
	}
	
	public void onClick_btn_GeneratePassword(ActionEvent event) {
		char[] passwordDisplay = generatePassword(8);
		String string = new String(passwordDisplay);
		txt_passwordgen.setText(string);
	}
	
	public void onClick_btn_SavePassword(ActionEvent event) {
		txt_passwordgen.clear();
	}

	private static char[] generatePassword(int length) {
	      String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String generatedPass = capitalLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = generatedPass.charAt(random.nextInt(generatedPass.length()));
	      }
	      return password;
	   }

}
