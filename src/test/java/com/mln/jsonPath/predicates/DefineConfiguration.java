package com.mln.jsonPath.predicates;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DefineConfiguration {
    File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");

    @Test
    public void defaultConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        String matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[2].date");
        System.out.println(matchDate);

    }
    @Test
    public void customConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        configuration = configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        String matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[3].date");
        System.out.println(matchDate);

    }
}
