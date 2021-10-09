package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class PasswordGeneratorController {
	
	@FXML
	private TextField password_txt;
	@FXML
	private Button generatePassword_btn;
	@FXML
	private Button copyToClipboard_btn;
	@FXML
	private ChoiceBox<Integer> passwordLength_cb;
	@FXML
	private CheckBox symbols_chkbx;
	@FXML
	private CheckBox numbers_chkbx;
	@FXML
	private CheckBox lowercase_chkbx;
	@FXML
	private CheckBox uppercase_chkbx;
	
	public void initialize()
	{
		passwordLength_cb.getItems().clear();
		passwordLength_cb.getItems().addAll(
				4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
	}
	
	public void onClick_btn_GeneratePassword(ActionEvent event)
	{
		try {
			int passlength = passwordLength_cb.getValue() - 1;
			String password = PasswordLogic.makePassword(passlength);
			password_txt.setText(password);
		}
		catch (Exception e) {
			System.out.println("Please select a password length");
		}
	}
	
	public void onClick_btn_CopyToClipboard(ActionEvent event)
	{
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(password_txt.getText());
		clipboard.setContent(content);
	}
	
	public void onClick_btn_BackToMain(ActionEvent event) throws IOException
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	window.show();
	}

}
