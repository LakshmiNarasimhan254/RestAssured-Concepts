package com.mln.pojoConcepts.jacksonannotations.jsonignore;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties({"first_Name","last_Name"})
@JsonPropertyOrder(alphabetic = true)
// @JsonPropertyOrder({"id","first_Name","last_Name","age"})
public class Student {
     private String last_Name;
     private String first_Name;
     private int subjectId;
     @JsonIgnore
     private int age;
     private String id ;
     private List skills;
    private Date currentDate;


     public String getFirst_Name() {
         return first_Name;
     }
     public void setFirst_Name(String first_Name) {
         this.first_Name = first_Name;
     }
     public String getLast_Name() {
         return last_Name;
     }
     public void setLast_Name(String last_Name) {
         this.last_Name = last_Name;
     }
     public int getSubjectId() {
         return subjectId;
     }
     public void setSubjectId(int subjectId) {
         this.subjectId = subjectId;
     }
     public int getAge() {
         return age;
     }
     public void setAge(int age) {
         this.age = age;
     }
     public String getId() {
         return id;
     }
     public void setId(String id) {
         this.id = id;
     }
     public List getSkills() {
         return skills;
     }
     public void setSkills(List skills) {
         this.skills = skills;
     }
     public Date getCurrentDate() { return currentDate;}
    public Student setCurrentDate(Date currentDate) {this.currentDate = currentDate;return this;}



 }
