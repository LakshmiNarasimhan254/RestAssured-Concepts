package com.mln.pojoConcepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentsMain {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		Students student1 = new Students();
		student1.setFirst_Name("Krishnaveni");
		student1.setLast_Name("Patti");
		student1.setSubjectId(1);
		student1.setAge(98);
		student1.setId(18);
		student1.setSkills(Arrays.asList("Java","Python"));

		System.out.println(
				student1.getFirst_Name()+ ","
						+student1.getLast_Name() + ","
						+student1.getAge() +","
						+student1.getSubjectId() +","
						+student1.getSkills() +","
						+student1.getId());



		//From Jackson Bind - converting the Data in student1 in to Json String 
		ObjectMapper mapper = new 	ObjectMapper();
		String Student1Json = mapper
			.writerWithDefaultPrettyPrinter()
			.writeValueAsString(student1);
		
		
		System.out.println(Student1Json);
		RestAssured.baseURI ="http://localhost:3000/";
    	RestAssured
		.given()
			.header("Content-Type","Application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Student1Json)
		.when()
			.post("/Students/")
		.then()
			.statusCode(201)
			.log().all();
    


	}

}
