package application;

import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;

public class ExportToFile {

	
	public static void doDownloadCSV(String userName, String path) throws IOException {
		ObservableList<Credential> arr =  (ObservableList<Credential>) CredentialsTableViewController.getCredentials();
		FileWriter out = new FileWriter(path + "stuff" + System.currentTimeMillis() + ".csv", true);
		for(Credential c : arr) {
			out.write(c.getUrl()+"," + c.getUsername() + "," +c.getPassword()+",");
		}
		out.close();
	}
}
