package com.mln.demos;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void postReq01(){
		
		
		RestAssured.baseURI="https://reqres.in/api";
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "Srinath");
		jsonObject.put("job", "Automation Tester");
		System.out.println(jsonObject.toJSONString());
		
		RestAssured
			.given()
				.header("Content-Type","Application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonObject.toJSONString())
			.when()
				.post("/users/")
			.then()
				.statusCode(201)
				.log().all();
			
				
		
	}
	
	@Test
	public void postReq02(){
		
		
		RestAssured.baseURI ="http://localhost:3000/";
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("First Name", "Aiyappan");
		jsonObject.put("Last Name", "Nair");
		jsonObject.put("Age", "40");
		jsonObject.put("SubjectId", "1");
		System.out.println(jsonObject.toJSONString());
		
		RestAssured
			.given()
				.header("Content-Type","Application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonObject.toJSONString())
			.when()
				.post("/Students/")
			.then()
				.statusCode(201)
				.log().all();
			
				
		
	}

}
