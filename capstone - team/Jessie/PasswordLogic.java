package application;

import java.util.*;
import java.security.SecureRandom;

public class PasswordLogic {
	
	public static String makePassword(int length, boolean uc, boolean sy, boolean nb, boolean wd)
	{
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String symbol = "`~!@#$%^&*()-_=+|}{][;:',<.>/?";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length/4; i++)	{
            int randomIndex = random.nextInt(lower.length());
            sb.append(lower.charAt(randomIndex));
        }
        
        if (uc == false) {
        	for (int i = 0; i < length/4; i++)	{
        		int randomIndex = random.nextInt(upper.length());
        		sb.append(upper.charAt(randomIndex));
        	}
        }
        
        if (nb == false) {
        	for (int i = 0; i < length/4; i++)	{
        		int randomIndex = random.nextInt(number.length());
        		sb.append(number.charAt(randomIndex));
        	}
        }
        
        if (sy == false) {
        	for (int i = 0; i < length/4; i++)	{
        		int randomIndex = random.nextInt(symbol.length());
        		sb.append(symbol.charAt(randomIndex));
        	}
        }
        
        String pass1 = sb.toString();
        
        int pass1Length = pass1.length();
        int rest = length - pass1Length;
        for (int i = 0; i < rest; i++)	{
            int randomIndex = random.nextInt(lower.length());
            sb.append(lower.charAt(randomIndex));
        }
        
        String finalpass = scramblePassword(sb.toString());
        //will figure out how to get random dictionary words later
        if (wd == true) {
        	finalpass = "test" + finalpass;
        }
        return finalpass;
	}
	
	public static String scramblePassword(String s)
	{
		String[] scram = s.split("");
        List<String> letters = Arrays.asList(scram);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(s.length());
        for (String c : letters) {
            sb.append(c);
        }
        return sb.toString();
	}
}
