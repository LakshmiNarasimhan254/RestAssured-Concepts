package com.mln.restjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

public class PostReq {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL ("http://localhost:3000/Indo-Pak-Series/");
		HttpURLConnection connectionObj =(HttpURLConnection) url.openConnection();
		connectionObj.setRequestMethod("POST");
		connectionObj.setRequestProperty("Content-Type", "application/json");
		
		
		File file = new File("C:\\Users\\laksh\\db.json");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		
		while (br.readLine()!=null){
			sb.append(br.readLine());
			
		}
		String strJsonBody = sb.toString();
		System.out.println(strJsonBody);
		byte[] inputJson = strJsonBody.getBytes();
		
		connectionObj.setDoOutput(true);
		OutputStream ops = connectionObj.getOutputStream();
		ops.write(inputJson);
		
		int iStatusCode = connectionObj.getResponseCode();
		String strStatusMsg = connectionObj.getResponseMessage();
		System.out.println(iStatusCode + ":" + strStatusMsg);
	}

}
