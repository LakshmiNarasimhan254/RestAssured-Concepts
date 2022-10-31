package com.mln.jacksonannotations.jsonrootvalue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;


@JsonRootName(value = "students")
public class Student {
     private String last_Name;
     private String first_Name;
     private int subjectId;
     private int age;
     private String id ;
     private List skills;

     private Devices device;

     @JsonProperty("firstName")
     public String getFirst_Name() {
         return first_Name;
     }
     public void setFirst_Name(String first_Name) {
         this.first_Name = first_Name;
     }


     @JsonProperty(value= "lastName")
     public String getLast_Name() {
         return last_Name;
     }
     public void setLast_Name(String last_Name) {
         this.last_Name = last_Name;
     }

     @JsonProperty(value= "subjectId")
     public int getSubjectId() {
         return subjectId;
     }
     public void setSubjectId(int subjectId) {
         this.subjectId = subjectId;
     }

     @JsonProperty(value= "age")
    public int getAge() {
         return age;
     }
     public void setAge(int age) {
         this.age = age;
     }

     @JsonProperty(value= "id")
      public String getId() {
         return id;
     }
    public void setId(String id) {
         this.id = id;
     }

     @JsonProperty(value= "skills")
    public List getSkills() {
         return skills;
     }
    public void setSkills(List skills) {
         this.skills = skills;
     }

     @JsonProperty(value= "devices")
    public Devices getDevice(){ return device;}
    public void setDevices(Devices device){this.device=device;}

 }
