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
	public void start(Stage primaryStage) throws Exception {
		
		//This will load our fxml file that we generated with Scene Builder
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/logincontroller.fxml"));
		Scene scene = new Scene(root);
				
		primaryStage.setTitle("Password Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		try {
			launch(args);
		}catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, there was an error!");

			alert.showAndWait();
		}
	}
}