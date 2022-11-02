package com.mln.pojoConcepts.jacksonannotations.jsonrootvalue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Arrays;


public class Serializer {
     Student student = new Student();
     Devices devices = new Devices();
     Faker faker = new Faker();

    public Student setStudent() {
      student.setFirst_Name(faker.name().firstName());
      student.setLast_Name(faker.name().lastName());
      student.setAge(faker.number().numberBetween(10,34));
      student.setId(faker.idNumber().valid());
      student.setSubjectId(faker.number().numberBetween(1,3));
      student.setSkills(Arrays.asList(faker.programmingLanguage().name(),faker.programmingLanguage().name(),faker.programmingLanguage().name()));
      student.setDevices(setDevice());
      return student;
    }

    public Devices setDevice(){
        devices.setDeviceType("Mobile");
        devices.setDeviceName("Iphone");
        devices.setDeviceModelNo("14 Pro Max");
        return devices;
    }
    @Test
    public void jsonSerializer() throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String serializedStudent= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(setStudent());
        System.out.println(serializedStudent);
    }
}
