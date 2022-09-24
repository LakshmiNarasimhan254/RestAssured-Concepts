package com.mln.pojoConcepts.usingFixtureFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Subject {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

    //Constructor
    public Subject(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
