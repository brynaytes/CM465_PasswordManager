package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class ReadingText {
	
	/**
	 * I refactored this code to return every line in the
	 * password file as a array list. This prevents passwords with spaces 
	 * from getting cut in half.
	 * 
	 * The array list also makes it easier to read the returned values.
	 * 
	 *  -- example use -- 
	 * try {
	 * System.out.println(reader());
	 * } catch (Exception e) {
	 * 	e.printStackTrace();
	 * }
	 * 
	 */
	
	
	static String fileName = "PasswordFile-PleaseDontRead.csv";
	
	
	public static ArrayList<Credential> reader(){
	ArrayList<Credential> arr = new ArrayList<Credential>();
		
       	File file = new File(fileName);
        Scanner input;
        String[] tempList;
		try {
			input = new Scanner (file);
			while(input.hasNext()) {
				tempList =  input.nextLine().split(",",0);
				for(int i = 2; i < tempList.length; i+=3) {
					arr.add(new Credential(tempList[i - 2],tempList[i-1],tempList[i] ));
				}
			}
        	input.close();
        	return arr;
        
		} catch (FileNotFoundException e) {
		//	System.out.println("error handled, returning blank array");

			return arr;
		}
     }
	
	
}
