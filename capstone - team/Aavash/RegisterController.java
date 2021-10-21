package application;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordFeild;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;


public class RegisterController implements Initializable{
	
@FXML
private ImageView sheildImageView;
@FXML
private Button closeButton;
@FXML
private Label registrationMessageLabel;
@FXML
private PasswordField setPasswordField;
@FXML
private PasswordField confirmPasswordField;
@FXML
private Label confirmPasswordLabel;
@FXML
private TextField firstnameTextFeild;
@FXML
private TextField lastnameTextFeild;
@FXML
private TextField usernameTextFeild;


	  public void intalize(URL url, ResourceBundel resourceBundle) {
		  File shieldFile = new File( pathname: "Image/8.png");
		  Image shieldImage = new Image(shieldFile.toURI().tostring());
		  shieldImageView.setImage(shieldImage);
	  }
	  public void registerButtonAction(ActionEvent event) {
		  registerUser();
		  if(setPasswordField.getText().equals(confirmPasswordField.getText())) {
	    		 confirmPasswordLabel.setText("you are set")); 
	    		
	    	  }
	      } else {
	    	  confirmPasswordLable.setText("password does not match");
	      }
		
		  
	  }
	  public void closeButtonOnAction(ActionEvent event) {
		  Stage stage = (Stage) closeButton.getScence().getWindow();
		  stage.close();
		  Platform.exit();
		  
	  }
      public void registerUser(){
    	  DatabaseConnection connectNow = new DatabaseConnection();
    	  Connection connectDB = connectNow.getConnection();
    	  
    	  String firstname = firstnameTextFeild.getText();
    	  String lastname = lastnameTextFeild.getText();
    	  String username = usernameTextFeild.getText();
    	  String password = setPasswordField.getText();
    	  
    	  String insertFeilds = "";
    	  String insertValues = firstname +"','" + lastname +"','" + username +"','" + password +"')";
    	  String insertToRegister = insertFeilds + insertValues ;
    
    	try {  
          
           Statement statement = connectDB.createStatement();
           Statement.executeUpdate(insertToRegister );
           
           registrationMessageLabel.setText("User has been registered successfully.");
    		
    		
   }catch (Exception e) {
    	e.printStackTrace();
		e.getCause();
 
      }
      
}