package com.mln.pojoConcepts.jacksonannotations.jsonvalue;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder(alphabetic = true)
// @JsonPropertyOrder({"id","first_Name","last_Name","age"})
public class Student {
     private String last_Name;
     private String first_Name;
     private int subjectId;
     private int age;

     @JsonRawValue
     private String id ;

     private List skills;

     @JsonGetter(value = "FirstName")
     public String getFirst_Name() {
         return first_Name;
     }

     public void setFirst_Name(String first_Name) {
         this.first_Name = first_Name;
     }
    @JsonGetter(value= "LastName")
     public String getLast_Name() {
         return last_Name;
     }

     public void setLast_Name(String last_Name) {
         this.last_Name = last_Name;
     }

     @JsonGetter(value= "SubjectId")
     public int getSubjectId() {
         return subjectId;
     }


     public void setSubjectId(int subjectId) {
         this.subjectId = subjectId;
     }

    @JsonGetter(value= "Age")
    public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

    @JsonGetter(value= "Id")
    public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

    @JsonGetter(value= "Skills")
    public List getSkills() {
         return skills;
     }

     public void setSkills(List skills) {
         this.skills = skills;
     }

    @JsonValue
    public List<Object> useThisSerialiser(){
         List<Object> serialiser = new ArrayList<>();
         serialiser.add(this.first_Name);
         serialiser.add(this.last_Name);
         serialiser.add(this.age);
         serialiser.add(this.id);
         serialiser.add(this.subjectId);
         serialiser.add(this.skills);
        return serialiser;
    }

 }
