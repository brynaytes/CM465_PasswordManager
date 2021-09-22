package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private TextField txt_password;
	@FXML
	private TextField txt_username;
	@FXML
	private TextField txt_URL;
	@FXML
	private TableView<String> ReadScrollPane;
	
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
	
	public void onClick_btn_ShowPasswords() {
		try {
			ReadScrollPane.getItems().add(ReadingText.reader().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	
	public void onClick_btn_Exit(ActionEvent event) {
		System.exit(0);
	}

}
