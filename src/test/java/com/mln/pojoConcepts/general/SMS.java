package com.mln.pojoConcepts.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SMS {
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @JsonProperty("Subjects")
    private List<Subject> subjects;
    @JsonProperty("Students")
    private List<Student> students;



}
