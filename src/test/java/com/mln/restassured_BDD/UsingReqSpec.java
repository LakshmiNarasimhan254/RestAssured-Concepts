package com.mln.restassured_BDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class UsingReqSpec {

    RequestSpecification rs1 = RestAssured.given();

    @BeforeSuite
    public void setRequestSpecification(){
        rs1.baseUri("https://dummyjson.com");
        rs1.basePath("products");
        rs1.contentType(ContentType.JSON);
        RestAssured.requestSpecification =rs1; // if this is set then,
        // need not pass the specigication object in  every given/spec. This spec will be taken by default
    }
    @Test
    public void getAllProducts() {
        Response responseBody = given()
                .spec(rs1).when().get(""); //.spec can be removed due to line 21
      String  responseJson = responseBody.getBody().prettyPrint();
        System.out.println(responseJson);
    }
    @Test
    public void getSingleProduct() {
        Response responseBody = given() //This uses the default specification
                .when().get("/2");
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }

    @Test
    public void addSingleProducts() {
        RequestSpecification rs2 = RestAssured.given();
        rs2.baseUri("https://dummyjson.com");
        rs2.basePath("products/add");
        rs2.contentType(ContentType.JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "BMW Pencil");
        rs2.body(jsonObject.toJSONString());
        Response responseBody = given()
                .spec(rs2).when().post();
        String  responseJson = responseBody.getBody().prettyPrint();//.spec can be removed due to line 21
        System.out.println(responseJson);
    }

}
