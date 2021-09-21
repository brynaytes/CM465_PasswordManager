package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	static String fileName = "PasswordFile-PleaseDontRead.txt";
	
	
	public static ArrayList<String> reader() throws Exception{
		ArrayList<String> arr = new ArrayList<String>();
		
        File file = new File(fileName);
        Scanner input = new Scanner (file);
        
        while (input.hasNext()) {
            arr.add( input.nextLine());
        }
        
        input.close();
        return arr;
     }
	
	
}
