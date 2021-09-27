package application;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingAndEntering2 {
	
	static String fileName = "PasswordFile-PleaseDontRead.csv";
	public static void main(String[] args) {
		try {
		writeToFile("people.url");
		writeToFile("bob");
		writeToFile("dlkfadhf");
		}catch(Exception e){}
	}
	
	public static void writeToFile(String textToWrite) throws IOException {
		FileWriter out = new FileWriter(fileName, true); //Creates file if not found, true allows for appending onto the file if it already exists
		//System.out.println("Printed: " + textToWrite);
		out.write(textToWrite + ","); //Actaully writes info handed to it
		out.close();  //Closes Input stream
	}
	
	
	
	
}
