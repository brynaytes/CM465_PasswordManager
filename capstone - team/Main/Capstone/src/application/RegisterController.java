package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
			  Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Username Required");
				alert.setContentText("Please enter a username.");
				alert.show();
		 	  usernameTextField.requestFocus();
		  }
		  else if(setPasswordTextField.getText().isBlank())
		  {
			  Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Password Required");
				alert.setContentText("Please enter a password.");
				alert.show();
			  setPasswordTextField.requestFocus();
		  }
		  else if(confirmPasswordTextField.getText().isEmpty())
		  {
			  Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Password Confirmation Required");
				alert.setContentText("Please confirm your password.");
				alert.show();
			  confirmPasswordTextField.requestFocus();
		  }
		  else if(setPasswordTextField.getText().equals(confirmPasswordTextField.getText()) == false)
		  {
			  Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Password Mismatch");
				alert.setContentText("Passwords do not match, please try again.");
				alert.show();
			  setPasswordTextField.clear();
			  confirmPasswordTextField.clear();
			  setPasswordTextField.requestFocus();
		  }
		  else if(phoneTextField.getText().length() != 10)
		  {
			  Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Invalid Phone Number");
				alert.setContentText("Please enter a valid phone number (do not include parentheses, spaces or hyphens).");
				alert.show();
			  phoneTextField.clear();
			  phoneTextField.requestFocus();
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
				tableViewScene.getStylesheets().add(getClass().getResource("LightTheme.css").toExternalForm());
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
	  String encryptedpassword = PasswordUtil.encrypt(setPasswordTextField.getText());
    	  String UsernameSQL= "SELECT * FROM user_account WHERE user_id = '"+ usernameTextField.getText()+"';";
    	  String RegisterSQL= "INSERT INTO user_account (user_id, password, phone_number, email)"
					+ "VALUES ('"+usernameTextField.getText()+"','"+encryptedpassword+"','"+phoneTextField.getText()+"','"+emailTextField.getText()+"');";
    	  
    	try {
    		//Connection to the Database
    		Connection c = DBUtil.getDataSource().getConnection();
    		Statement stmt = c.createStatement();
    		ResultSet results = stmt.executeQuery(UsernameSQL);
    		
    		if(results.next()) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setHeaderText("Username unavailable");
    			alert.setContentText("That username is not available. Please choose a different username.");
    			alert.show();
    		} else {
    			stmt.executeUpdate(RegisterSQL);
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("Success");
    			alert.setContentText("Registration successful");
    			alert.show();
    		}
    		
    		setPasswordTextField.clear();
    		confirmPasswordTextField.clear();
    		emailTextField.clear();
    		phoneTextField.clear();
    		usernameTextField.clear();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
      }
	
      @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
