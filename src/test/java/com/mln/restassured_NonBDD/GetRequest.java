package com.mln.restassured_NonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void GetProducts(){
		RestAssured.baseURI = "https://dummyjson.com/";
		RequestSpecification requestSpecification =	RestAssured.given();
		Response response = requestSpecification.request(Method.GET,"products");
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());	
		System.out.println(response.getStatusLine());
		}

}
