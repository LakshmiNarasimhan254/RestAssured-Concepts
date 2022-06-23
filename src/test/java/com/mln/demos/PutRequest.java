package com.mln.demos;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void putReq(){
		RestAssured.baseURI="https://reqres.in/api";
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "Srinath");
		jsonObject.put("job", "API Automation Tester");
		
		RestAssured
		.given()
			.header("Content-Type", "application.json")
			.contentType(ContentType.JSON)
			.body(jsonObject.toJSONString())
		.when()
			.put("/users/")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
