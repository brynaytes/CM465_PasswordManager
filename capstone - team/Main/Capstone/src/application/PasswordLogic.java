package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PasswordLogic {
	
	public static String makePassword(int length, boolean uc, boolean lc, boolean sy, boolean nb, boolean wd)
	{
		String password = "";
		int i = 0;
		
		while(i < length) {

			if(nb == true && i < length) {
				String randomDigit = randomCharacter("0123456789");
				password = insertAtRandom(password, randomDigit);
				i++;
			}

			if(sy == true && i < length) {
				String randomSymbol = randomCharacter("`~!@#$%^&*()-_=+|}{][;:,<.>/?");
				password = insertAtRandom(password, randomSymbol);
				i++;
			}

			if(uc == true && i < length) {
				String randomUppercase = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				password = insertAtRandom(password, randomUppercase);
				i++;
			}
			
			if(lc == true && i < length) {
				String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
				password = insertAtRandom(password, randomLowercase);
				i++;
			}
			
			if(nb == false && sy == false && uc == false && lc == false && wd == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("No Items Selected");
				alert.setContentText("Please include at least one character type or word.");
				alert.show();
				break;
			}
			
			if(nb == false && sy == false && uc == false && lc == false && wd == true) {
				break;
			}
			
		}
		return password;
	}
	
	public static String randomCharacter(String characters) {
		int n = characters.length();
		int r = (int)(n * Math.random());
		return characters.substring(r, r + 1);
	}
	
	public static String insertAtRandom(String str, String toInsert) {
		int n = str.length();
		int r = (int)((n + 1) * Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);
	}	
	
	public static String dictionaryWord(String password) {

		List<String> lines = null;
		try {
			lines = Files.readAllLines(new File("words.txt").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		final Random rand = new Random();
		String word = lines.get(rand.nextInt(lines.size()));
        password = word + password;

		return password;
	}
	
	public static int checkCount(boolean uc, boolean lc, boolean sy, boolean nb, boolean wd)
	{
		int count = 0;
		
		if (uc == true) {
			count++;
		}
		if (lc == true) {
			count++;
		}
		if (sy == true) {
			count++;
		}
		if (nb == true) {
			count++;
		}
		if (wd == true) {
			count++;
		}
		
		return count;
	}
}
