package com.mln.restassured_BDD;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetRequest {

	@Test(enabled =false)
	    public void getReq01(){
		RestAssured.baseURI ="https://reqres.in/api";
		Response response= RestAssured.get("/users/2");
		ResponseBody responsebody = response.getBody();
		System.out.println(responsebody.asPrettyString());
		//System.out.println(responsebody.asString());

	}
	
	@Test(enabled =true)
	public void getReqBddStyle(){	
		RestAssured.baseURI ="https://reqres.in/api";
	    given().
			param("", "").
			header("","").
		when().
			get("/users/2").
		then()
			.statusCode(200). 
			log().all();		
	}
	
	@Test(enabled =true)
	public void getReq02(){	
		RestAssured.baseURI ="http://localhost:3000/";
	    given().
			param("", "").
			header("","").
		when().
			get("/Students/").
		then()
			.statusCode(200). 
			log().all();		
	}


}
