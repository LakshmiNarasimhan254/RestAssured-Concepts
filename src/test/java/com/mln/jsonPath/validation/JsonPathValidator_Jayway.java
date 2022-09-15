package com.mln.jsonPath.validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathValidator_Jayway {

	File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");
	String jsonPath_CaptainNames = "$..players[?(@.role=='Captain')].playerName";
	String jsonPath_ViceCaptainNames = "$..players[?(@.role=='Vice-Captain')].playerName";


	//this method uses Jayway json path

	@Test
	public void parsEveryTime_getJsonPath() throws IOException{

		List<Object>captains =	JsonPath.read(jsonFile, jsonPath_CaptainNames);
		
		int iCount=0;
		for (Object captain : captains)	{		
			System.out.println("The Captain of Team "+ iCount + " " + captain);
			iCount++;
		}
	}

	@Test	
	public void parseOnce_getJsonPath() throws IOException{
		InputStream jsonInputStream =  new FileInputStream(jsonFile);
		Object parsedJson = Configuration.defaultConfiguration().jsonProvider().parse(jsonInputStream.readAllBytes());

		List<Object>captains =	JsonPath.read(parsedJson, jsonPath_CaptainNames);
		List<Object>viceCaptains =	JsonPath.read(parsedJson, jsonPath_ViceCaptainNames);
		int iCount=0;
		for (Object captain : captains)	{		
			System.out.println("The Captain of Team "+ iCount + " " + captain);
			iCount++;
		}
		iCount=0;
		for (Object viceCaptain : viceCaptains)	{		
			System.out.println("The Captain of Team "+ iCount +" "+ viceCaptain);
			iCount++;
		}
	}


	@Test	
	public void fluentAPI() throws IOException {
		DocumentContext parsedJson = JsonPath.parse(jsonFile);
		List<Object>captains = parsedJson.read(jsonPath_CaptainNames);
		int iCount=0;
		for (Object captain : captains)	{		
			System.out.println("The Captain of Team "+ iCount + " " + captain);
			iCount++;
		}
	}

	@Test	
	public void fluentAPI_withConfiguration() throws IOException {
		Configuration configuration = Configuration.defaultConfiguration();
				DocumentContext parsedJson = JsonPath.parse(jsonFile);
		List<Object>captains=JsonPath
								.using(configuration)
								.parse(jsonFile)
								.read(jsonPath_CaptainNames);
		int iCount=0;
		for (Object captain : captains)	{		
			System.out.println("The Captain of Team "+ iCount + " " + captain);
			iCount++;
		}
	}




}
