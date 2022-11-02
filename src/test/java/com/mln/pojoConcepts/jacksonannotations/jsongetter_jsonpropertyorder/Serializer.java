package com.mln.pojoConcepts.jacksonannotations.jsongetter_jsonpropertyorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class    Serializer {
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
    public void jsonGetterSerializer() throws IOException {
        ObjectMapper mapper =  new ObjectMapper();
        String serializedStudent= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(setStudent());
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, setStudent());
        System.out.println(serializedStudent);
    }
}
