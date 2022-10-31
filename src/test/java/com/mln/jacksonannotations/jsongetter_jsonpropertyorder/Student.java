package com.mln.jacksonannotations.jsongetter_jsonpropertyorder;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
   @JsonPropertyOrder(alphabetic = true)
  // @JsonPropertyOrder({"id","first_Name","last_Name","age"})
   public class Student {
        private String last_Name;
        private String first_Name;
        private int subjectId;
        private int age;

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



    }
