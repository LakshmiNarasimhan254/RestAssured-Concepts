package com.mln.jsonPath.predicates;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DefineConfiguration {
    File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");

    @Test
    public void defaultConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        String matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[2].date");
        System.out.println(matchDate);

    }

    //This Configuration option is used to return null if JsonPathNotFoundexception is hit
    @Test
    public void defaultNullConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        configuration = configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        String matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[3].date");
        System.out.println(matchDate);

    }

    //This Configuration option is used to return the result always as String
    //regardless of whether a string is returned or a list. This is to be on the safer side and avoid
    //ClassCastException
    @Test
    public void alwayReturnAsListConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        configuration = configuration.addOptions(Option.ALWAYS_RETURN_LIST);
        List matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[0].date");
        System.out.println(matchDate);
    }

    //This Configuration option is used to supress JsonPathNotFoundexception and return null

    @Test
    public void suppressExceptionConfiguration() throws IOException {
        Configuration configuration = Configuration.defaultConfiguration();
        configuration=configuration.addOptions(Option.SUPPRESS_EXCEPTIONS);
        String matchDate = JsonPath.using(configuration).parse(jsonFile).read("$.matches[3].date");
        System.out.println(matchDate);
    }


    }
