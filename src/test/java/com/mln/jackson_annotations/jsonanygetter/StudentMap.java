package com.mln.jackson_annotations.jsonanygetter;



import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;


public class StudentMap {
    Map<String,Object> studentMap = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, Object> studentMap) {
        this.studentMap = studentMap;
    }
}
