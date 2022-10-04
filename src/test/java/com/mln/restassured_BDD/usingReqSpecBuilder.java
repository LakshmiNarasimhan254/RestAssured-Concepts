package com.mln.restassured_BDD;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class usingReqSpecBuilder {
    RequestSpecBuilder requestSpecBuilder =  new RequestSpecBuilder();
    RequestSpecification rs1;

    @BeforeSuite
    public void setRequestSpecification(){
        requestSpecBuilder.setBaseUri("https://dummyjson.com");
        requestSpecBuilder.setBasePath("products");
        requestSpecBuilder.setContentType(ContentType.JSON);
        rs1 = requestSpecBuilder.build();
        RestAssured.requestSpecification =rs1; // if this is set then,
        // need not pass the specigication object in  every given/spec. This spec will be taken by default
    }
    @Test
    public void getAllProducts() {
        Response responseBody = given()
                .spec(rs1).when().get(); //.spec can be removed due to line 23
        String  responseJson = responseBody.getBody().prettyPrint();
        System.out.println(responseJson);
    }
}
