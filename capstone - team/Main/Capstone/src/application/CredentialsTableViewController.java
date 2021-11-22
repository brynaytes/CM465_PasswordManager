package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class CredentialsTableViewController implements Initializable {
	
	@FXML private TableView<Credential> credentialsTable;
	@FXML private TableColumn<Credential, String> urlCol;
	@FXML private TableColumn<Credential, String> usernameCol;
	@FXML private TableColumn<Credential, String> passwordCol;
	
	
	public void onClick_btn_BackToMain(ActionEvent event) throws IOException
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	if(MainController.lightTheme == true)
    		tableViewScene.getStylesheets().add(getClass().getResource("LightTheme.css").toExternalForm());
    	else
    		tableViewScene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
    	window.show();
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		credentialsTable.setEditable(true);
		
		urlCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("url"));
		urlCol.setCellFactory(TextFieldTableCell.forTableColumn());
		urlCol.setOnEditCommit(new EventHandler<CellEditEvent<Credential, String>>() {

			@Override
			public void handle(CellEditEvent<Credential, String> event) {
				
				try {
					
					Connection c = DBUtil.getDataSource().getConnection();
					Statement stmt = c.createStatement();
					String SQL = "UPDATE credential SET url = '"+event.getNewValue()+"' WHERE (url = '"+event.getRowValue().getUrl()+"' AND credential_id <> 0);";
					stmt.executeUpdate(SQL);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		});
		
		usernameCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("username"));
		usernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		usernameCol.setOnEditCommit(new EventHandler<CellEditEvent<Credential, String>>() {
			
			@Override
			public void handle(CellEditEvent<Credential, String> event) {
				
				try {
					
					Connection c = DBUtil.getDataSource().getConnection();
					Statement stmt = c.createStatement();
					String SQL = "UPDATE credential SET username = '"+event.getNewValue()+"' WHERE (username = '"+event.getRowValue().getUsername()+"' AND credential_id <> 0);";
					stmt.executeUpdate(SQL);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		});
		
		passwordCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("password"));
		passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
		passwordCol.setOnEditCommit(new EventHandler<CellEditEvent<Credential, String>>() {
			
			@Override
			public void handle(CellEditEvent<Credential, String> event) {
				
				try {
					
					Connection c = DBUtil.getDataSource().getConnection();
					Statement stmt = c.createStatement();
					String SQL = "UPDATE credential SET password = '"+event.getNewValue()+"' WHERE (password = '"+event.getRowValue().getPassword()+"' AND credential_id <> 0);";
					stmt.executeUpdate(SQL);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		});
		
		credentialsTable.setItems(getCredentials());
	}
	
	public static ObservableList<Credential> getCredentials()
	{
		ArrayList<Credential> arr = new ArrayList<Credential>();
		try {
			//Connection to the Database
			Connection c = DBUtil.getDataSource().getConnection();
			//SQL for selecting the columns we want from the credential table
			String SQL = "SELECT url, username, password FROM credential WHERE user_id='"+Logincontroller.username+"';";
			//ResultSet
			ResultSet rs = c.createStatement().executeQuery(SQL);
			
			while(rs.next()) {
				Credential cred = new Credential(rs.getString(1),rs.getString(2),rs.getString(3));
				arr.add(cred);
			}
			
			return (FXCollections.observableList(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
