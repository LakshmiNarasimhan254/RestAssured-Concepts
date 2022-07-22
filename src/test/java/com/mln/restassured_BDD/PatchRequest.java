package com.mln.restassured_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchRequest {
	
	@Test
	public void patchReq(){
		RestAssured.baseURI="https://reqres.in/api";
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "Srinath");
		jsonObject.put("job", "API Automation Testerrr");
		
		RestAssured
		.given()
			.header("Content-Type", "application.json")
			.contentType(ContentType.JSON)
			.body(jsonObject.toJSONString())
		.when()
			.patch("/users/")
		.then()
			.statusCode(200)
			.log().all();
		

}

}
