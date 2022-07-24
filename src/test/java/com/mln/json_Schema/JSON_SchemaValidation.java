package com.mln.json_Schema;



import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSON_SchemaValidation {

	@Test
	public void validation_JSON_Schema(){


//		File inputJson = new File("C:\\My Folder\\Srinath\\Learnings\\API\\RestAssuredProject"
//				+"\\src\\test\\resources\\JSON Files\\"
//				+"SMS_Updates_Part3.json");
		
		
		File JsonSchema = new File("C:\\My Folder\\Srinath\\Learnings\\API\\RestAssuredProject"
				+"\\src\\test\\resources\\"
				+"SMS_Schema.json");
		

		RestAssured.baseURI ="http://localhost:3000/";
		RestAssured
//		.given()
//		.header("Content-Type","Application/json")
//		.contentType(ContentType.JSON)
//		.accept(ContentType.JSON)
//		.body(inputJson)
//		.when()
//		.post("/Students/")
//		.then()
//		.statusCode(201)
//		.log().all()
		
		
		.given()
			.param("", "")
			.header("","")
		.when()
			.get("/Students/1")
		.then()
			.statusCode(200)
			.log().all()
			.body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));

		
		


	}
}
