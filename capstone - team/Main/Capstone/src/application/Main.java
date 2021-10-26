package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage){
		try {
		//This will load our fxml file that we generated with Scene Builder
		Parent root;
		
			root = FXMLLoader.load(getClass().getResource("/fxml/logincontroller.fxml"));
		
		Scene scene = new Scene(root);
				
		primaryStage.setTitle("Password Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Oops, something went wrong!");
			//alert.setContentText("");

			alert.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		
			launch(args);
		
		
			
		
	}
}