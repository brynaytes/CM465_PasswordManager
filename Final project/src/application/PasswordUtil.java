package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	
	  
	  public static String encrypt(String pass) {
		  
		  String password = pass; 
	      String encryptedpassword = null;  
	        try   
	        {  
	            MessageDigest m = MessageDigest.getInstance("MD5");  
	            
	            m.update(password.getBytes());  
	            
	            byte[] bytes = m.digest();  
	              
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	                
	            encryptedpassword = s.toString();  
	        }   
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }  
	          
	       // System.out.println("Plain-text password: " + password);  
	       // System.out.println("Encrypted password using MD5: " + encryptedpassword);  
	        
	        return encryptedpassword;
	  }
	  

}
