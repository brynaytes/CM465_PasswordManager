import java.io.*;
import java.net.*;
import java.util.Scanner;
public class PostTesting {
	public static final String LINK = ("https://gp6ounv3jd.execute-api.us-east-2.amazonaws.com/default/PostTesting_1");

	 public static void syncData() {
		 //This method will sync the local database with the cloud one
	 }
	 public static void loginToCloud() {
		 //Requests authentication permission from cloud database -- 
		 //im not really sure if we need this or what
	 }
	 public static void SendData() {
		 //Sends updated password lists to cloud
		 String username = "Bob";
		 String password = "dkjfh";
		 String url = "place.com";
		 try {
			postHTML("{\"name\":\""+ username +"\",\"password\":\""+ password +"\",\"url\":\""+url+"\"} ");
		} catch (Exception e) {
			//Error in sending link occurred
			//e.printStackTrace();
		}
		 
	 }
	   
	   
	   //sends post request with given string
	   public static void postHTML(String s) throws Exception {
		   
			   
			    // Define the server endpoint to send the HTTP request to
			    URL serverUrl = 
			    new URL(LINK);
			    HttpURLConnection urlConnection = (HttpURLConnection)serverUrl.openConnection();
			 
			    // Indicate that we want to write to the HTTP request body
			    urlConnection.setDoOutput(true);
			    urlConnection.setRequestMethod("POST");
			 
			    // Writing the post data to the HTTP request body
			    BufferedWriter httpRequestBodyWriter = 
			            new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			    //httpRequestBodyWriter.write("{\"name\":\"xyz\",\"age\":\"20\"} ");
			    httpRequestBodyWriter.write(s);

			    
			    httpRequestBodyWriter.close();
			 
			    // Reading from the HTTP response body
			    Scanner httpResponseScanner = new Scanner(urlConnection.getInputStream());
			    while(httpResponseScanner.hasNextLine()) {
			        System.out.println(httpResponseScanner.nextLine());
			    }
			    httpResponseScanner.close();
			 
	   }


	   public static void main(String[] args) throws Exception
	   {
		   SendData();
	    // postHTML("{\"name\":\"xyz\",\"password\":\"20\",\"url\":\"place.com\"} ");
	   }
	}