package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCredentialsController {
	@FXML
	private TextField URL_txt;
	@FXML
	private TextField username_txt;
	@FXML
	private TextField password_txt;
	@FXML
	private Button backtoMain_btn;
	@FXML
	private Button storeCred_btn;

	public void onClick_btn_StoreCredentials(ActionEvent event)
	{
		
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
