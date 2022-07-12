package com.mln.restjava;

import static io.restassured.RestAssured.baseURI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetReq {

	public static void main(String[] args) throws IOException {	

		URL url = new URL("http://localhost:3000/Indo-Pak-Series/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int iStatusCode = connection.getResponseCode();
		String strStatusMsg = connection.getResponseMessage();
				System.out.println(iStatusCode + ":" + strStatusMsg);
				
		 //To get the response body
				
		 InputStream inputstreamObj = connection.getInputStream();
		 InputStreamReader inputstreamreaderObj = new InputStreamReader(inputstreamObj);
		 BufferedReader bufferedreaderObj = new BufferedReader(inputstreamreaderObj);	 
		 StringBuffer sbResponseBody = new StringBuffer();
		 
		 while(bufferedreaderObj.readLine()!=null){
			 sbResponseBody.append(bufferedreaderObj.readLine());
		 }
		 System.out.println(sbResponseBody);
	}

}
