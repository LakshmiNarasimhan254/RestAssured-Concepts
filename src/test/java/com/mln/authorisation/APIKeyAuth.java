package com.mln.authorisation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIKeyAuth {
    RequestSpecification rs1 = RestAssured.given();
    @BeforeSuite
    public void setRequestSpecification(){
        rs1.baseUri("https://api.openweathermap.org/data/2.5/weather");
        rs1.contentType(ContentType.JSON);
        RestAssured.requestSpecification =rs1; // if this is set then,
        // need not pass the specigication object in  every given/spec. This spec will be taken by default
    }
    @Test
    public void apiKeyUsingQueryParam(){
        Response responseBody = given()
                .queryParam("q","Tampa")
                .queryParam("appid","00a3d100d7e96d6d504378aaf4c4dc4d")
                .when()
                .get();
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }
    @Test
    public void apiKeyUsingHeader(){
        Response responseBody = given()
                .queryParam("q","Tampa")
                .header("x-Api-key","00a3d100d7e96d6d504378aaf4c4dc4d")
                .when()
                .get();
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }
}
