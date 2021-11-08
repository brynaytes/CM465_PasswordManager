package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController implements Initializable{
	
@FXML
private ImageView shieldImageView;
@FXML
private Button closeButton;
@FXML
private Label registrationMessageLabel;
@FXML
private PasswordField setPasswordTextField;
@FXML
private PasswordField confirmPasswordTextField;
@FXML
private Label confirmPasswordLabel;
@FXML
private TextField emailTextField;
@FXML
private TextField phoneTextField;
@FXML
private TextField usernameTextField;


	  public void intalize(URL url, ResourceBundle resourceBundle) {
		  File shieldFile = new File("Image/8.png");
		  Image shieldImage = new Image(shieldFile.toURI().toString());
		  shieldImageView.setImage(shieldImage);
	  }
	  
	  public void registerButtonAction(ActionEvent event) {
		  
		  if(usernameTextField.getText().isBlank())
		  {
			  System.out.println("Username is a required field.");
		      usernameTextField.requestFocus();
		  }
		  else if(setPasswordTextField.getText().isBlank())
		  {
			  System.out.println("You must enter a password.");
			  setPasswordTextField.requestFocus();
		  }
		  else if(confirmPasswordTextField.getText().isEmpty())
		  {
			  System.out.println("Please confirm the password.");
			  confirmPasswordTextField.requestFocus();
		  }
		  else if(setPasswordTextField.getText().equals(confirmPasswordTextField.getText()) == false)
		  {
			  System.out.println("Passwords do not match, please try again.");
			  setPasswordTextField.clear();
			  confirmPasswordTextField.clear();
			  setPasswordTextField.requestFocus();
		  }
		  else 
			  registerUser(); 
	  }
	  
	  public void closeButtonOnAction(ActionEvent event) {
		  try {
		  		Parent tableViewParent;
			
				tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/logincontroller.fxml"));
				
				Scene tableViewScene = new Scene(tableViewParent);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(tableViewScene);
				window.show();
			  } catch (IOException e) {
					e.printStackTrace();
				}
		  //Stage stage = (Stage) closeButton.getScene().getWindow();
		  //stage.close();
		  //Platform.exit();
		  
	  }
	  
      public void registerUser()
      {
    	  String UsernameSQL= "SELECT * FROM user_account WHERE user_id = '"+ usernameTextField.getText()+"';";
    	  String RegisterSQL= "INSERT INTO user_account (user_id, password, phone_number, email)"
					+ "VALUES ('"+usernameTextField.getText()+"','"+setPasswordTextField.getText()+"','"+phoneTextField.getText()+"','"+emailTextField.getText()+"');";
    	  
    	try {
    		//Connection to the Database
    		Connection c = DBUtil.getDataSource().getConnection();
    		Statement stmt = c.createStatement();
    		ResultSet results = stmt.executeQuery(UsernameSQL);
    		
    		if(results.next())
    			System.out.println("That username is unavailable, please enter a new username.");
    		else
    			stmt.executeUpdate(RegisterSQL);
    		
    		System.out.println("Registration Successful");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
      }
	
      @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
