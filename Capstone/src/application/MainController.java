package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private TextField txt_password;
	@FXML
	private TextField txt_username;
	@FXML
	private TextField txt_URL;
	
    public void onClick_btn_ViewCredentials(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/CredentialsTableView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);;
    	window.show();
    }
    
	public void onClick_btn_StoreCredentials(ActionEvent event) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(txt_URL.getText().toString() + "\n");
		sb.append(txt_username.getText().toString() + "\n");
		sb.append(txt_password.getText().toString() + "\n\n");
		
		File file = new File("PasswordFile-PleaseDontRead.txt");
		PrintWriter W = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		W.write(sb.toString());
		W.close();
		
		txt_URL.clear();
		txt_username.clear();
		txt_password.clear();
	}
	
	
	public void onClick_btn_Exit(ActionEvent event) {
		System.exit(0);
	}

}
