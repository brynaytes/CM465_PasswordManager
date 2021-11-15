package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
		try {
			//Connection to the Database
			Connection c = DBUtil.getDataSource().getConnection();
			Statement stmt = c.createStatement();
			//SQL for selecting the columns we want from the credential table
			String SQL = "INSERT INTO credential (url, username, password, user_id)"
						+ "VALUES ('"+URL_txt.getText()+"','"+username_txt.getText()+"','"+password_txt.getText()+"','"+Logincontroller.username+"');";
			stmt.executeUpdate(SQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		URL_txt.clear();
		username_txt.clear();
		password_txt.clear();
	}
	
	public void onClick_btn_BackToMain(ActionEvent event) throws IOException
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	tableViewScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	window.show();
	}
	
}
