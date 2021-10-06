package application;

public class PasswordLogic {
	
	public static String makePassword(int length, boolean uc, boolean sy, boolean nb)
	{
		String password = "";
		
		for(int i = 0; i < length -3; i++) 
		{
			password = password + randomCharacter("abcdefghijklmnopqrstuvwxyz");
		}

		if(nb == true) {
			String randomDigit = randomCharacter("0123456789");
			password = insertAtRandom(password, randomDigit);
		}
		else {
			String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
			password = insertAtRandom(password, randomLowercase);
		}
		
		if(sy == true) {
			String randomSymbol = randomCharacter("+-*/?!@#$%&");
			password = insertAtRandom(password, randomSymbol);
		}
		else {
			String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
			password = insertAtRandom(password, randomLowercase);
		}
		
		if(uc == true) {
			String randomUppercase = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			password = insertAtRandom(password, randomUppercase);
		}
		else {
			String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
			password = insertAtRandom(password, randomLowercase);
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

}
