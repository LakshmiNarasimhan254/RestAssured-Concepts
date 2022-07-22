package com.mln.jsonConstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Serialization {
	
	// dataObtained from front end form
	@Test
    public void serialize(){
    	Map<String,Object> JsonBody = new HashMap<String,Object>();
    	List <String> skils = new<String>ArrayList();
    	skils.add("Java");
    	skils.add("Selenium");
    	JsonBody.put("First_Name", "Christian");
    	JsonBody.put("Last_Name", "Fletcher");
    	JsonBody.put("SubjectId", 1);
    	JsonBody.put("Age", 51);
    	JsonBody.put("id", 17);
    	JsonBody.put("skills",skils);
    	
    	
    	RestAssured.baseURI ="http://localhost:3000/";
    	RestAssured
		.given()
			.header("Content-Type","Application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(JsonBody)
		.when()
			.post("/Students/")
		.then()
			.statusCode(201)
			.log().all();
    
    }


	
}
