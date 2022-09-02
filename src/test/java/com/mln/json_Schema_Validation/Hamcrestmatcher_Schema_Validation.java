package com.mln.json_Schema_Validation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Hamcrestmatcher_Schema_Validation {
	
  @Test
  public void validateJsonSchema() throws IOException {
	
	
	 File expectedJson = new File("src/test/resources/JSON_Files/SMS_Single.json");
	 File expectedJsonSchema = new File("src/test/resources/SMS_Schema.json");
	 String expectedJsonString = FileUtils.readFileToString(expectedJson,"UTF-8");
	 
	 MatcherAssert.assertThat(expectedJsonString, JsonSchemaValidator.matchesJsonSchema(expectedJsonSchema));
  }
}
