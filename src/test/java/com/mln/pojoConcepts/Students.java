package com.mln.pojoConcepts;

import java.util.List;

public class Students {
	
	private String First_Name;	
	private String Last_Name;
	private int SubjectId;
	private int Age;
	private int id ;
	private List skills;
	
	
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}
	public int getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(int SubjectId) {
		this.SubjectId = SubjectId;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
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

	

}
