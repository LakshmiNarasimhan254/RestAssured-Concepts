package com.mln.authorisation;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAuth {

    RequestSpecification rs1 = RestAssured.given();
    @BeforeSuite
    public void setRequestSpecification(){
        rs1.baseUri("https://postman-echo.com/");
        rs1.basePath("basic-auth");
        rs1.contentType(ContentType.JSON);
        RestAssured.requestSpecification =rs1; // if this is set then,
        // need not pass the specigication object in  every given/spec. This spec will be taken by default
    }
    @Test
    public void validCredentials(){
        Response responseBody = given()
                .auth()
                .basic("postman", "password")
                .when()
                .get();
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }
    @Test
    public void invalidCredentials(){
        Response responseBody = given()
                .auth()
                .basic("postman1", "password1")
                .when()
                .get();
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }
}
