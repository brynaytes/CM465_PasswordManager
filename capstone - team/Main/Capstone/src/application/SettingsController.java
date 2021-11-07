package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;


public class SettingsController {
	
	private Button backtoMain_btn;
	
	public void onClick_btn_BackToMain(ActionEvent event) throws IOException
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	window.show();
	}
	
	public void onClick_btn_Export(ActionEvent event)throws IOException
	{
		try {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			ExportToFile.doDownloadCSV("username", directoryChooser.showDialog((Stage)((Node)event.getSource()).getScene().getWindow()).toString() + "\\" );
		}catch(NullPointerException e) {
			//User closed the popup window without selecting a folder. Or other path error I think
		}
	}
	
}
