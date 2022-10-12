package com.mln.authorisation;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OAuth2point0 {
    RequestSpecification rs1 = RestAssured.given();
    @BeforeSuite
    public void setRequestSpecification(){
        rs1.baseUri("https://api.github.com/user/repos");
        rs1.contentType(ContentType.JSON);
        RestAssured.requestSpecification =rs1; // if this is set then,
        // need not pass the specigication object in  every given/spec. This spec will be taken by default
    }
    @Test
    public void oAuth2point0UsingAuth() throws IOException {
        String token = "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";
        Response responseBody = given()
                .auth().oauth2(token)
                .when()
                .get();
        String responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        readingRepoName(responseJson);
        //System.out.println(responseJson);
    }
    public void readingRepoName(String responseJson) throws IOException {

        DocumentContext parsedJson = JsonPath.parse(responseJson);
        List<Object> repoNames=parsedJson
                .read("$..full_name");
        int iCount=0;
        for (Object repoName : repoNames)	{
            System.out.println("S:No"+ iCount + " " + repoName);
            iCount++;
        }
    }
}


