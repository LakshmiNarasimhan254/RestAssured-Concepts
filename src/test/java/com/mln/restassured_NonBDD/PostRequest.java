package com.mln.restassured_NonBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@Test
	public void CreateProduct(){
	RestAssured.baseURI = "https://dummyjson.com/";
	RequestSpecification requestSpecification =	RestAssured.given();
	
	
	

	
	requestSpecification.contentType(ContentType.JSON);
	requestSpecification.body("{\n\"title\" : \"BMW Penils\"\n}");
	Response response = requestSpecification.request(Method.POST, "products/add");
	
	System.out.println(response.getBody().asPrettyString());
	System.out.println(response.getStatusCode());	
	System.out.println(response.getStatusLine());
	}

}
