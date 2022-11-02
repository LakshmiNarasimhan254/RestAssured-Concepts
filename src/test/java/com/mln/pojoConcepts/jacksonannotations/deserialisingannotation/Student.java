package com.mln.pojoConcepts.jacksonannotations.deserialisingannotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class Student {

	private String first_Name;
 	private String last_Name;
	private int subjectId;
	private int age;
	private String id ;
	@JsonProperty("Skills")
	private List skills;

	//@JsonCreator()
	public Student(	@JsonProperty("Id")	String id){
		this.id=id;
	}

	public String getFirst_Name() {
		return first_Name;
	}
	@JsonSetter("FirstName")
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}
	@JsonSetter("LastName")
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public int getSubjectId() {
		return subjectId;
	}
	@JsonSetter("SubjectId")
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getAge() {return age;}
	@JsonSetter("Age")
	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	//public void setId(String id) {this.id = id;	}

	public List getSkills() {
		return skills;
	}


	public void setSkills(List skills) {
		this.skills = skills;
	}


	
	


	

}
