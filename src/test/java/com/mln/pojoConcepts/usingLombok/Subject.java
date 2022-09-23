package com.mln.pojoConcepts.usingLombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
}
