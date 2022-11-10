package com.mln.pojoConcepts.jacksonannotations.jsonrawvalue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Serializer {
     Student student = new Student();
     Faker faker = new Faker();

    public Student setStudent() {
      student.setFirst_Name(faker.name().firstName());
      student.setLast_Name(faker.name().lastName());
      student.setAge(faker.number().numberBetween(10,34));
      student.setId(faker.idNumber().valid());
      student.setSubjectId(faker.number().numberBetween(1,3));
      student.setSkills(Arrays.asList(faker.programmingLanguage().name(),faker.programmingLanguage().name(),faker.programmingLanguage().name()));
      return student;
    }

    @Test
    public void jsonRawValueSerializer() throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
        String serializedStudent= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(setStudent());
        System.out.println(serializedStudent);
    }
}
