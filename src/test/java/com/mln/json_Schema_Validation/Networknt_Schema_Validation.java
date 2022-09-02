package com.mln.json_Schema_Validation;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class Networknt_Schema_Validation {
	
  @Test
  public void validateJsonSchema() throws IOException {
	  ObjectMapper objectMapper = new ObjectMapper();
	  JsonSchemaFactory jsonFactory =  JsonSchemaFactory.getInstance(VersionFlag.V201909);
	  
	  
	  File expectedJson = new File("src/test/resources/JSON_Files/SMS_Single.json");
	  JsonNode jsonNode = objectMapper.readTree(expectedJson);
	  
	  InputStream inputStream = new FileInputStream("src/test/resources/SMS_Schema.json") ; 
	  JsonSchema jsonSchema = jsonFactory.getSchema(inputStream);	
	  
	  Set<ValidationMessage> result = jsonSchema.validate(jsonNode);
	  
	  System.out.println(result);
	  
  }
}
