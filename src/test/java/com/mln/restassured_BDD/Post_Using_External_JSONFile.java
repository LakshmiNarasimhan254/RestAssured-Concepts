package com.mln.restassured_BDD;

import java.io.File;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_Using_External_JSONFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI ="http://localhost:3000/";
		
	
		
		RestAssured
			.given()
				.header("Content-Type","Application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(new File("C:\\Users\\laksh\\MyFirst_Updates_Part2.json"))
			.when()
				.post("/Students/")
			.then()
				.statusCode(201)
				.log().all();
			

	}

}
