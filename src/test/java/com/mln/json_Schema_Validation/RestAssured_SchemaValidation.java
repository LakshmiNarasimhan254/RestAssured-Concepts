package com.mln.json_Schema_Validation;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
public class RestAssured_SchemaValidation {

	@Test(enabled=false)
	public void validation_JSON_Schema_ClasspathMethod(){
		RestAssured.baseURI ="http://localhost:3000/";
		RestAssured		
		.given()
			.param("", "")
			.header("","")
		.when()
			.get("/Students/1")
		.then()
			.statusCode(200)
			.log().all()		
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SMS_Schema.json"));
	}
	@Test(enabled=false)
	public void validation_JSON_Schema_asFile(){
		File inputSchema = new File(System.getProperty("user.dir")+"/src/test/resources/"+"SMS_Schema.json");
		RestAssured.baseURI ="http://localhost:3000/";
		RestAssured		
		
		
		.given()
			.param("", "")
			.header("","")
		.when()
			.get("/Students/1")
		.then()
			.statusCode(200)
			.log().all()		
			.body(JsonSchemaValidator.matchesJsonSchema(inputSchema));
	}
	
	@Test(enabled=false)
	public void validation_JSON_Schema_asInputStream() throws FileNotFoundException{			
		FileInputStream inputSchema = new  FileInputStream(System.getProperty("user.dir")+"/src/test/resources/"+"SMS_Schema.json");
		RestAssured.baseURI ="http://localhost:3000/";
		RestAssured			
		.given()
			.param("", "")
			.header("","")
			//.body(inputJson)
		.when()
			.get("/Students/1")
		.then()
			.statusCode(200)				
			.body(JsonSchemaValidator.matchesJsonSchema(inputSchema))
		    .log().all();
	}
	
	@Test(enabled=true)
	public void validation_JSON_Schema_asReader() throws FileNotFoundException{	
		Reader inputSchema = new FileReader(System.getProperty("user.dir")+"/src/test/resources/"+"SMS_Schema.json");
		RestAssured.baseURI ="http://localhost:3000/";
		RestAssured				
		.given()
			.param("", "")
			.header("","")
			//.body(inputJson)
		.when()
			.get("/Students/1")
		.then()
			.statusCode(200)				
			.body(JsonSchemaValidator.matchesJsonSchema(inputSchema))
		    .log().all();
	}
}
