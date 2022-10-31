package com.mln.pojoConcepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serializer {

    @Test
    public void serialization_simpleJson() throws JsonProcessingException {
        //Creating a Student Object
        Student student = new Student();
        //Setting the Values
        student.setFirst_Name("Krishnaveni");
        student.setLast_Name("Patti");
        student.setSubjectId(1);
        student.setAge(98);
        student.setId(18);
        student.setSkills(Arrays.asList("Java", "Python"));

        //Printing the object variables using getter methods
        System.out.println(
                student.getFirst_Name() + ","
                        + student.getLast_Name() + ","
                        + student.getAge() + ","
                        + student.getSubjectId() + ","
                        + student.getSkills() + ","
                        + student.getId());


        //From Jackson Bind - converting the Data in student1 in to Json String
        ObjectMapper mapper = new ObjectMapper();
        String studentObjAsJson = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(student);

        // Printing the Json object (Serialised JSON Object)
        System.out.println(studentObjAsJson);
    }

    @Test
    public void serialization_complexJson() throws IOException {
        SMS sms = new SMS();

        List<Subject> subjects = new ArrayList<Subject>();
        Subject firstSubject = new Subject();
        firstSubject.setName("Ilavarasan");
        firstSubject.setId("1");
        Subject secondSubject = new Subject();
        secondSubject.setName("Raja");
        secondSubject.setId("2");
        subjects.add(firstSubject);
        subjects.add(secondSubject);

        List<Student> students = new ArrayList<Student>();
        Student firstStudent = new Student();
        firstStudent.setFirst_Name("Aditha");
        firstStudent.setLast_Name("Karikalan");
        firstStudent.setId(1);
        firstStudent.setAge(35);
        firstStudent.setSubjectId(1);
        List<String> firstStudentskills = new ArrayList<String>();
        firstStudentskills.add("Elephant fight");
        firstStudentskills.add("Romance");
        firstStudent.setSkills(firstStudentskills);

        Student secondStudent = new Student();
        secondStudent.setFirst_Name("ArulMozhi");
        secondStudent.setLast_Name("Verman");
        secondStudent.setId(2);
        secondStudent.setAge(32);
        secondStudent.setSubjectId(2);
        List<String> secondStudentskills = new ArrayList<String>();
        secondStudentskills.add("Sword fight");
        secondStudentskills.add("Righteousness");
        firstStudent.setSkills(secondStudentskills);
        students.add(firstStudent);
        students.add(secondStudent);


        sms.setStudents(students);
        sms.setSubjects(subjects);

        File jsonFile = new File("src/test/resources/JSON_Files/SerializedSMS.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, sms);
    }
}


