package com.mln.jsonPath.predicates;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class InLinePredicate {

	File jsonFile = new File("src/test/resources/JSON_Files/Matches_Updated.json");
	String jsonPath_CaptainNames = "$..players[?(@.role=='Captain')].playerName";
	String jsonPath_ViceCaptainNames = "$..players[?(@.role=='Vice-Captain')].playerName";
	String jsonPath_With2Conditions = "$..players[?(!(@.role=='Captain' && @.playerid>2))].playerName";

	@Test
	public void jayawayInlinePredicate() throws IOException 
	{
		DocumentContext parsedJson = JsonPath.parse(jsonFile);
		List<Object>captains = parsedJson.read(jsonPath_With2Conditions);
		System.
		out.println(captains);
	}


}
