package com.mln.jackson_annotations.jsonanygetter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Serializer {

    public ObjectMapper mapper;
    public Map<String,Object>studentMapValues;
    public StudentMap studentMap;
    Faker faker = new Faker();

    private Map<String,Object> setMapValues(){
        studentMapValues = new HashMap<>();
        studentMapValues.put("firstName",faker.name().firstName());
        studentMapValues.put("lastName",faker.name().lastName());
        studentMapValues.put("age",faker.number().numberBetween(10,45));
        studentMapValues.put("id",faker.idNumber().valid());
        studentMapValues.put("skills", Arrays.asList(faker.programmingLanguage().name(),faker.programmingLanguage().name()));
       return studentMapValues;
    }

    @Test
    public void serialize() throws JsonProcessingException {
        mapper = new ObjectMapper();
        studentMap = new StudentMap();
        studentMap.setStudentMap(setMapValues());

        String serializedStudentMap=  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentMap);
        System.out.println(serializedStudentMap);
    }


}
