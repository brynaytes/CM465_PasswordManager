package application;

public class PasswordLogic {
	
	public static String makePassword(int length, boolean uc, boolean sy, boolean nb, boolean wd)
	{
		String password = "";

		for(int i = 0; i < length/4; i++) {
			
			String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
			password = insertAtRandom(password, randomLowercase);

			if(nb == false) {
				String randomDigit = randomCharacter("0123456789");
				password = insertAtRandom(password, randomDigit);
			}

			if(sy == false) {
				String randomSymbol = randomCharacter("+-*/?!@#$%&");
				password = insertAtRandom(password, randomSymbol);
			}

			if(uc == false) {
				String randomUppercase = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				password = insertAtRandom(password, randomUppercase);
			}
		}
		
		int passLength1 = password.length();
	    int rest = length - passLength1;
	    for (int i = 0; i < rest; i++)	{
	        String randomLowercase =  randomCharacter("abcdefghijklmnopqrstuvwxyz");
			password = insertAtRandom(password, randomLowercase);
	    }
	    
	    if (wd == true) {
	    	//will figure out how to get random dictionary words later
        	password = "test" + password;
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
