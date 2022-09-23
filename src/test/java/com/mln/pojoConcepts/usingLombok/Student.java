package com.mln.pojoConcepts.usingLombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
	@JsonProperty("first_Name")
	private String first_Name;
	@JsonProperty("last_Name")
	private String last_Name;
	@JsonProperty("subjectId")
	private int subjectId;
	@JsonProperty("age")
	private int age;
	@JsonProperty("id")
	private int id ;
	@JsonProperty("skills")
	private List skills;
}
