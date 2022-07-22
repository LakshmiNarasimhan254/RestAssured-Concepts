package com.mln.restassured_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //import as static 

public class DeleteRequest {

	@Test
	public void deleteReq01(){
		baseURI ="https://reqres.in/api/";
		given()
			.header("","")
		 .when()
		 	.delete("/users/2")
		 .then()
		 	.statusCode(204)
		 	.log().all();
		 
				
	}
	
	@Test
	public void deleteReq02(){
		baseURI ="http://localhost:3000/";
		given()
			.header("","")
		 .when()
		 	.delete("/Students/7")
		 .then()
		 	.statusCode(200)
		 	.log().all();
		 
				
	}
}
