package com.mln.restassured_NonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {


	@Test
	public void putRequest(){
		RestAssured.baseURI ="https://dummyjson.com/";
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification
					.contentType(ContentType.JSON)
					.body("{\n\"title\" : \"iPhone Galaxy +1\"\n}");
		
		Response response = RestAssured.request(Method.PUT,"products/1");
		
		System.out.println(response.body().asPrettyString());
		System.out.println(response.getStatusLine());
		
	}

}
