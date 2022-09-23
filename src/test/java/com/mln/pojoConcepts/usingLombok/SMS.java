package com.mln.pojoConcepts.usingLombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mln.pojoConcepts.usingLombok.Student;
import com.mln.pojoConcepts.usingLombok.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SMS {
    @JsonProperty("Subjects")
    private List<Subject> subjects;
    @JsonProperty("Students")
    private List<Student> students;

}
