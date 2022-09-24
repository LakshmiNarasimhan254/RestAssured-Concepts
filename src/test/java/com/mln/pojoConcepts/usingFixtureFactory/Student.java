package com.mln.pojoConcepts.usingFixtureFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Student {
	@JsonProperty("first_Name")
	private String first_Name;
	@JsonProperty("last_Name")
	private String last_Name;
	@JsonProperty("subjectId")
	private String subjectId;
	@JsonProperty("age")
	private int age;
	@JsonProperty("id")
	private String id ;
	@JsonProperty("skills")
	private List skills;

	//Constructor
	public Student(String first_Name, String last_Name, String subjectId, int age, String id, List skills) {
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.subjectId = subjectId;
		this.age = age;
		this.id = id;
		this.skills = skills;
	}
}
