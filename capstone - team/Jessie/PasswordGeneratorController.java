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
	private CheckBox uppercase_chkbx;
	@FXML
	private CheckBox lowercase_chkbx;
	@FXML
	private CheckBox word_chkbx;
	
	public void initialize()
	{
		passwordLength_cb.getItems().clear();
		passwordLength_cb.getItems().addAll(
				4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
				31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,
				56,57,58,59,60,61,62,63,64);
		passwordLength_cb.setValue(8);
	}
	
	public void onClick_btn_GeneratePassword(ActionEvent event)
	{
		int passlength = passwordLength_cb.getValue();
		boolean uc = uppercase_chkbx.isSelected();
		boolean lc = lowercase_chkbx.isSelected();
		boolean sy = symbols_chkbx.isSelected();
		boolean nb = numbers_chkbx.isSelected();
		boolean wd = word_chkbx.isSelected();
		
		String password = PasswordLogic.makePassword(passlength, uc, lc, sy, nb, wd);
		
		if (wd == true) {
			password = PasswordLogic.dictionaryWord(password);
		}
		
		password_txt.setText(password);

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

	public void onClick_btn_RestoreDefault(ActionEvent event)
	{
		passwordLength_cb.setValue(8);
		password_txt.setText("");
		symbols_chkbx.setSelected(false);
		numbers_chkbx.setSelected(false);
		uppercase_chkbx.setSelected(false);
		lowercase_chkbx.setSelected(false);
		word_chkbx.setSelected(false);
	}
}
