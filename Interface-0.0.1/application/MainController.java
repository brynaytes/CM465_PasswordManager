package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import localStorage.CreatingAndEntering;
import localStorage.ReadingText;

public class MainController {
	
	public MainController() {}
	
	@FXML private TextField UserNameField;

	@FXML private TextField PasswordField;

	@FXML private Label ReadScrollPane;
	
	@FXML
	public void StoreCredentials(ActionEvent event) {
		try {
			CreatingAndEntering.writeToFile(UserNameField.getText());
			CreatingAndEntering.writeToFile(PasswordField.getText());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Password Stored: " + UserNameField.getText());
	}
	
	@FXML
	public void ShowPasswords(ActionEvent event) {
		try {
			ReadScrollPane.setText(ReadingText.reader().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	
	public void Exit(ActionEvent event) {
		System.exit(0);
	}

}
