package com.mln.jsonPath.predicates;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import static com.jayway.jsonpath.Filter.filter;
import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.JsonPath.parse;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FilterApiPredicate {
    File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");
    String jsonPath_CaptainNames = "$..players[?(@.role=='Captain')].playerName";
    String jsonPath_ViceCaptainNames = "$..players[?(@.role=='Vice-Captain')].playerName";
    //String jsonPath_With2Conditions = "$..players[?(!(@.role=='Captain' && @.playerid>2))].playerName";
    @Test
    public void jayawayFilterPredicate() throws IOException{
        Filter filter = Filter.filter(Criteria.where("role").is("Vice-Captain").and("playerid").gt(2));
        DocumentContext parsedJson = JsonPath.parse(jsonFile);
        List<Map<String,Object>> captains = parsedJson.read("$..players[?]",filter);
        for(Map captain: captains){
           Iterator<Entry<String,Object>> iterator=  captain.entrySet().iterator();
            while (iterator.hasNext()){
                Entry<String, Object> captainRecord = iterator.next();
                System.out.println("Key: "+ captainRecord.getKey() + " , Value: " + captainRecord.getValue());

            }
        }
        }

        @Test
        public void jayawayFilterPredicateStatic() throws IOException {

        List<Map<String,Object>> captains = parse(jsonFile).read("$..players[?]",filter(
                where("role")
                        .is("Vice-Captain")
                        .and("playerid")
                        .gt(2)));

            for(Map captain: captains){
                Iterator<Entry<String,Object>> iterator=  captain.entrySet().iterator();
                while (iterator.hasNext()){
                    Entry<String, Object> captainRecord = iterator.next();
                    System.out.println("Key: "+ captainRecord.getKey() + " , Value: " + captainRecord.getValue());

                }
        }
    }
}




