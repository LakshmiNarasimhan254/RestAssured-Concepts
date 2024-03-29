package com.mln.pojoConcepts.jacksonannotations.deserialisingannotation;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Deserializer {

    @Test
    public void deSerializationWithJsonSetter() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(jsonFile, Student.class);
        System.out.println(
                student.getFirst_Name() + ","
                        + student.getLast_Name() + ","
                        + student.getAge() + ","
                        + student.getSubjectId() + ","
                        + student.getId());


    }

    @Test
    public void deSerializationUsingJsonAnySetter() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        ObjectMapper mapper = new ObjectMapper();
        StudentMap studentMap = mapper.readValue(jsonFile, StudentMap.class);
        System.out.println(
                studentMap.getStudentsMap());
    }

    @Test
    public void deSerializationUsingJsonProperty() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(jsonFile, Student.class);
        System.out.println(
                student.getSkills());


    }

    @Test
    public void deSerializationUsingJsonCreator() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(jsonFile, Student.class);
        System.out.println(
                student.getId());

    }

    @Test
    public void deSerializationUsingJacksonInject() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");

        InjectableValues injectableValues = new InjectableValues.Std().addValue(Boolean.class,true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setInjectableValues(injectableValues);
        Student student = mapper.readValue(jsonFile, Student.class);
        System.out.println(
                student.getDayScholar());

    }
    @Test
    public void deSerializationUsingJsonAlias() throws IOException {
        File jsonFile = new File("src/test/resources/JSON_Files/SerializedStudent.json");
        InjectableValues injectableValues = new InjectableValues.Std().addValue(Boolean.class,true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setInjectableValues(injectableValues);

       Student student = mapper.readValue(jsonFile, Student.class);
        System.out.println(
                student.getLast_Name());

    }
}
