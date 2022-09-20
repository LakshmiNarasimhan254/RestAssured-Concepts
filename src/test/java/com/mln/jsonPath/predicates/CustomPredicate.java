package com.mln.jsonPath.predicates;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomPredicate {
    File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");
    Predicate predicate = new Predicate() {
            @Override
            public boolean apply(PredicateContext ctx) {
                boolean predicate = ctx.item(Map.class).containsValue("Vice-Captain");
                return predicate;
            }

        };

    // The same thing can be written as a lambda expressed
    //Predicate predicate = ctx -> ctx.item(Map.class).containsValue("Vice-Captain");

    @Test
    public void jayawayCustomPredicate() throws IOException {
        List<Map<String,Object>> captains= JsonPath.parse(jsonFile).read("$..players[?]",predicate);
        for(Map captain: captains){
            Iterator<Map.Entry<String,Object>> iterator=  captain.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> captainRecord = iterator.next();
                System.out.println("Key: "+ captainRecord.getKey() + " , Value: " + captainRecord.getValue());

            }
        }
    }


}
