package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.File;
import java.util.ResourceBundle;
import java.net.URL;

public class Logincontroller implements Initializable{

	@FXML
	private Button cancelButton;
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
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File brandingFile =new File( "@Password%20Manager-logos.jpeg");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);
		
		File lockFile =new File( "@Screenshot%202021-10-04%20012321.jpg");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageview.setImage(lockImage);
		
		
	}
	public void loginButtonOnAction(ActionEvent event) {
	
		if ((usernameTextField.getText().isBlank() == false) && enterPasswordField.getText().isBlank() == false)  {
			validatelogin();
		}else
		{
			loginMessageLabel.setText("Please Enter Username and Password");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage1=(Stage) cancelButton.getScene().getWindow();
				stage1.close();
	}
	
	public void validatelogin() {
		
	}
}
