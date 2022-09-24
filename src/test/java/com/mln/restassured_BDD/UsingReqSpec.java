package com.mln.restassured_BDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class UsingReqSpec {

    RequestSpecification requestSpecification = RestAssured.given();

    @BeforeSuite
    public void setRequestSpecification(){
        requestSpecification.baseUri("https://dummyjson.com");
        requestSpecification.basePath("products");
        requestSpecification.contentType(ContentType.JSON);
    }
    @Test
    public void getAllProducts() {
        Response responseBody = given()
                .spec(requestSpecification).when().get("");
      String  responseJson = responseBody.getBody().prettyPrint();
        System.out.println(responseJson);
    }
    @Test
    public void getSingleProducts() {
        Response responseBody = given()
                .spec(requestSpecification).when().get("/2");
        String  responseJson = responseBody.getBody().prettyPrint();
        System.out.println(responseJson);
    }
}
