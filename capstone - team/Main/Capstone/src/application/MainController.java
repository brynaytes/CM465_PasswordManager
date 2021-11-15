package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	
	public void onClick_btn_AddCredentials(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/AddCredentials.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
    }
	
	public void onClick_btn_GeneratePassword(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/PasswordGenerator.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
    }
	
	public void onClick_btn_ViewCredentials(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/CredentialsTableView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
    }
	
	public void onClick_btn_ViewSettings(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Settings.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
    }
    

	public void onClick_btn_Logout(ActionEvent event) throws IOException {
		/**
		 * 
		 * we need code to unassociate login info or something
		 * 
		 */
		
		
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/logincontroller.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
	}
	
	public void onClick_btn_Exit(ActionEvent event) {
		System.exit(0);
	}

}
