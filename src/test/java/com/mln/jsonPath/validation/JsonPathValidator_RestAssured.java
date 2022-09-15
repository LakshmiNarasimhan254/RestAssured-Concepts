package com.mln.jsonPath.validation;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;


public class JsonPathValidator_RestAssured {
	
	File file = new File("src/test/resources/JSON_Files/Matches_Updated.json");
	
		//This method uses Restassured Gson Path 	
		@Test
		public void getjsonPathRestAssured(){
			
			JsonPath jsonPath  = JsonPath.from(file);
			String playerName = jsonPath.getString("teams[0].players.find{it.playerName='Yuvraj'}.playerName");
			List<Object>playerDetails = jsonPath.with(file).getList("teams.players[0..1].skills[0]");

				for (Object playerDetail : playerDetails){
						System.out.println(playerDetail);
					
				}
		
		}
		
	

}
