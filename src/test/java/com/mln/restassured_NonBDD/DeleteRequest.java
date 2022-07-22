package com.mln.restassured_NonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void deleteProduct(){
		RestAssured.baseURI = "https://dummyjson.com/";
		RequestSpecification requestSpecification=RestAssured.given(); 
		Response response = requestSpecification.request(Method.DELETE,"products/1");
		
		
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusLine());
		
		
	}

}
