package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;


import java.net.URL;


public class Logincontroller {

	@FXML
	private Button cancelButton;
	@FXML
	private Button signupButton;
	//@FXML
	//private Label loginMessageLabel;
	@FXML
	private ImageView brandingImageView;
	@FXML
	private ImageView lockImageview;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField enterPasswordField;
	
	private final String testingAuth = "test";
	/*
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File brandingFile =new File( "@Password%20Manager-logos.jpeg");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);
		
		File lockFile =new File( "@Screenshot%202021-10-04%20012321.jpg");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageview.setImage(lockImage);
		
		System.out.println("starting test");
	}*/
	
	
	public void initialize() {
		//System.out.println("starting");
	}
	
	public void onClick_btn_register(ActionEvent event) {
		//System.out.println("registering");
		try {
			Parent tableViewParent;
			tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/registercontroller.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onClick_btn_login(ActionEvent event) {
	//	System.out.println("starting test");

		if ((usernameTextField.getText().isBlank() == false) && (enterPasswordField.getText().isBlank() == false))  {
			//System.out.println("validating");

			if(validatelogin()) {
				//System.out.println("login validated");
				Parent tableViewParent;
				try {
					tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
				
					Scene tableViewScene = new Scene(tableViewParent);
		    	
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		    	
					window.setScene(tableViewScene);
					window.show();
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			};
		}else
		{
			//System.out.println("something is empty");

			//loginMessageLabel.setText("Please Enter Username and Password");
		}
		
		if(usernameTextField.getText().isBlank() && (enterPasswordField.getText().isBlank())){
			try {
			Parent tableViewParent;
			
			tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			
			Scene tableViewScene = new Scene(tableViewParent);
    	
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
			window.setScene(tableViewScene);
			window.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
			
		}
		
	}
	

	public void cancelButton(ActionEvent event) {
		Stage stage1=(Stage) cancelButton.getScene().getWindow();
				stage1.close();
	}
	
	public boolean validatelogin() {
		//System.out.println(usernameTextField.getText());
		//System.out.println(enterPasswordField.getText());

		if((usernameTextField.getText().equals(testingAuth)) && (enterPasswordField.getText().equals(testingAuth))) {
			return true;
		}
	//	System.out.println("login invalid");
		return false;
	}
	
}
