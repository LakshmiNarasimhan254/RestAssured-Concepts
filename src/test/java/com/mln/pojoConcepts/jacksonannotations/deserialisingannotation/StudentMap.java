package com.mln.pojoConcepts.jacksonannotations.deserialisingannotation;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {
    private Map<String,Object> studentsMap = new HashMap<>();

    public Map<String, Object> getStudentsMap() {
        return studentsMap;
    }

    @JsonAnySetter
    public void setStudentsMap(String key,Object value) {
       studentsMap.put(key,value);
    }




}
