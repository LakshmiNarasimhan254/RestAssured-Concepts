package com.mln.pojoConcepts.general;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.testng.annotations.Test;



public class Deserializer {

	@Test
	public void deSerialization() throws IOException {
		File jsonFile = new File("src/test/resources/JSON_Files/SMS_Single.json");
		ObjectMapper mapper = new ObjectMapper();
		Student student =mapper.readValue(jsonFile, Student.class);
		System.out.println(
				student.getFirst_Name() + ","
						+ student.getLast_Name() + ","
						+ student.getAge() + ","
						+ student.getSubjectId() + ","
						+ student.getSkills() + ","
						+ student.getId());


	}
	@Test
	public void deSerializationWithArray() throws IOException {
		File jsonFile = new File("src/test/resources/JSON_Files/SMS.json");
		ObjectMapper mapper = new ObjectMapper();

		SMS sms =mapper.readValue(jsonFile, SMS.class);
		//Get all students
		for (Student s: sms.getStudents()){
			System.out.println(
					s.getFirst_Name() + ","
							+ s.getLast_Name() + ","
							+ s.getAge() + ","
							+ s.getSubjectId() + ","
							+ s.getSkills() + ","
							+ s.getId());
		}

		//To get one student details
		System.out.println("====================================");
		System.out.println(
				sms.getStudents().get(3).getFirst_Name() + ","
						+ sms.getStudents().get(3).getLast_Name() + ","
						+ sms.getStudents().get(3).getAge() + ","
						+ sms.getStudents().get(3).getSubjectId() + ","
						+ sms.getStudents().get(3).getSkills() + ","
						+ sms.getStudents().get(3).getId());


	}

	@Test
	public void deSerializationUsingJaywayJsonPath() throws IOException {
		File jsonFile = new File("src/test/resources/JSON_Files/SMS.json");
		JacksonMappingProvider jacksonMappingProvider = new JacksonMappingProvider();
		Configuration configuration =Configuration.builder().mappingProvider(jacksonMappingProvider).build();
	    SMS sms = JsonPath.using(configuration).parse(jsonFile).read("$", SMS.class);
		//Get all students
		for (Student s: sms.getStudents()){
			System.out.println(
					s.getFirst_Name() + ","
							+ s.getLast_Name() + ","
							+ s.getAge() + ","
							+ s.getSubjectId() + ","
							+ s.getSkills() + ","
							+ s.getId());
		}

		//To get one student details
		System.out.println("====================================");
		System.out.println(
				sms.getStudents().get(3).getFirst_Name() + ","
						+ sms.getStudents().get(3).getLast_Name() + ","
						+ sms.getStudents().get(3).getAge() + ","
						+ sms.getStudents().get(3).getSubjectId() + ","
						+ sms.getStudents().get(3).getSkills() + ","
						+ sms.getStudents().get(3).getId());


	}
	@Test
	public void deSerializationUsingRAJsonPath() throws IOException {
		File jsonFile = new File("src/test/resources/JSON_Files/SMS.json");
		JacksonMappingProvider jacksonMappingProvider = new JacksonMappingProvider();
		Configuration configuration =Configuration.builder().mappingProvider(jacksonMappingProvider).build();
		io.restassured.path.json.JsonPath jsonPath =io.restassured.path.json.JsonPath.with(jsonFile);
		jsonPath.getObject("$", SMS.class);
		SMS sms = JsonPath.using(configuration).parse(jsonFile).read("$", SMS.class);
		//Get all students
		for (Student s: sms.getStudents()){
			System.out.println(
					s.getFirst_Name() + ","
							+ s.getLast_Name() + ","
							+ s.getAge() + ","
							+ s.getSubjectId() + ","
							+ s.getSkills() + ","
							+ s.getId());
		}
	}

}
