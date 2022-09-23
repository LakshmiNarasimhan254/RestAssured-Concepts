package com.mln.pojoConcepts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Student {
	@JsonProperty("first_Name")
	private String first_Name;
	@JsonProperty("last_Name")
	private String last_Name;
	@JsonProperty("subjectId")
	private int subjectId;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getSkills() {
		return skills;
	}

	public void setSkills(List skills) {
		this.skills = skills;
	}

	@JsonProperty("age")
	private int age;
	@JsonProperty("id")
	private int id ;
	@JsonProperty("skills")
	private List skills;
	
	


	

}
