package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Logincontroller {

	@FXML
	private Button cancelButton;
	@FXML
	private Button signupButton;
	@FXML
	private Label loginMessageLabel;
	@FXML
	private ImageView brandingImageView;
	@FXML
	private ImageView lockImageview;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField enterPasswordField;
	public static String username;
	
	
	public void onClick_btn_register(ActionEvent event) throws IOException{
		//System.out.println("registering");
		
			Parent tableViewParent;
			tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/registercontroller.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
	}
	
	
	public void onClick_btn_login(ActionEvent event) throws IOException{

		if ((usernameTextField.getText().isBlank() == false) && (enterPasswordField.getText().isBlank() == false))  {

			if(validatelogin()) {
				username = usernameTextField.getText();

				//successful login, proceed to Main.fxml
				Parent tableViewParent;
				
					tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
				
					Scene tableViewScene = new Scene(tableViewParent);
		    	
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		    	
					window.setScene(tableViewScene);
					window.show();
		    	
			}
			
		} else
			loginMessageLabel.setText("The Username or Password fields cannot be blank.");
				
	}
	

	public void cancelButton(ActionEvent event) {
		Stage stage1=(Stage) cancelButton.getScene().getWindow();
				stage1.close();
	}
	
	public boolean validatelogin() {
		
		String SQL = "SELECT * FROM user_account WHERE user_id = '"+ usernameTextField.getText()+"';";
		
		String encryptedpassword = PasswordUtil.encrypt(enterPasswordField.getText());
		
		try {
    		//Connection to the Database
    		Connection c = DBUtil.getDataSource().getConnection();
    		Statement stmt = c.createStatement();
    		ResultSet validUser = stmt.executeQuery(SQL);
    		
    		if(validUser.next()) {
    			if(validUser.getString("password").equals(encryptedpassword))
    				return true;
    			else
    				loginMessageLabel.setText("Username or Password is incorrect.");
    		}
    		else
    			loginMessageLabel.setText("Username or Password is incorrect.");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	
}
