package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;


public class SettingsController implements Initializable {
	
	@FXML
	private Label username_lbl;
	@FXML
	private Label email_lbl;
	@FXML
	private Label phone_lbl;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		username_lbl.setText(Logincontroller.username);
		String setEmail = null;
		String setPhone = null;
		
		try {
			Connection c = DBUtil.getDataSource().getConnection();
			Statement stmt = c.createStatement();
			String getEmail = "SELECT email FROM user_account WHERE user_id='"+username_lbl.getText()+"';";
			String getPhone = "SELECT phone_number FROM user_account WHERE user_id='"+username_lbl.getText()+"';";
			ResultSet email = stmt.executeQuery(getEmail);
			while(email.next()) {
				setEmail = email.getString("email");
			}
			email_lbl.setText(setEmail);
			
			ResultSet phone = stmt.executeQuery(getPhone);
			while(phone.next()) {
				setPhone = phone.getString("phone_number");
			}
			phone_lbl.setText(setPhone);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
