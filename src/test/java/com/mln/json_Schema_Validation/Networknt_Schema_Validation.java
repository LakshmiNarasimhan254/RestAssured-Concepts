package com.mln.json_Schema_Validation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;

public class Networknt_Schema_Validation {
	
	
  @Test
  public void validateJsonSchema() {
	  ObjectMapper objMapper = new ObjectMapper();
	  JsonSchemaFactory.getInstance(VersionFlag.V201909);
  }
}
