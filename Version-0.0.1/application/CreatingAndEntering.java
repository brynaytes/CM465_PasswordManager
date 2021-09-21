package application;

import java.io.*;
public class CreatingAndEntering {
	

	/**In this version of the code we are catching errors in the method calling it. 
	 * Ideally this will look like
	 * try {
	 * 		writeToFile("This should be written to the file");
	 * } catch (IOException e) {
	 * 		e.printStackTrace();
	 * }
	 */
	
	static String fileName = "PasswordFile-PleaseDontRead.txt";
	
	public static void writeToFile(String textToWrite) throws IOException {
		FileWriter out = new FileWriter(fileName, true); //Creates file if not found, true allows for appending onto the file if it already exists
		System.out.println("Printed: " + textToWrite);
		out.write(textToWrite + "\n"); //Actaully writes info handed to it
		out.close();  //Closes Input stream
	}
	
}