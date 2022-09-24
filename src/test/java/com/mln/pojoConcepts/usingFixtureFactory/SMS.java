package com.mln.pojoConcepts.usingFixtureFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SMS {
    @JsonProperty("Subjects")
    private List<Subject> subjects;
    @JsonProperty("Students")
    private List<Student> students;

    public SMS(List<Subject> subjects, List<Student> students) {
        this.subjects = subjects;
        this.students = students;
    }
}
