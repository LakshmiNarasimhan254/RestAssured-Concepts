package com.mln.restassured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JsonValidations {


	@Test
	public void check_editionId(){
		baseURI ="http://localhost:3000/Indo-Pak-Series/";
		given()
		.header("Content-Type", "application.json")
		.contentType(ContentType.JSON)
		.when()
		.get()//Since am getting only the baseurl
		.then()
		.body("editionId",equalTo(2022));

		//		Integer object = get().getBody().jsonPath().getJsonObject("editionId");
		//		System.out.println(object);
	}
	@Test
	public void check_homeCountry(){
		baseURI ="http://localhost:3000/Indo-Pak-Series/";

		given()
		.header("Content-Type", "application.json")
		.contentType(ContentType.JSON)
		.when()
		.get()//Since am getting only the baseurl
		.then()
		.body("data.homeCountry",equalTo("India"));


		String object = get().getBody().jsonPath().getJsonObject("data.homeCountry");
		System.out.println(object);
	}

	@Test
	public void check_playerMinHeight(){
		baseURI ="http://localhost:3000/Indo-Pak-Series/";

		given()
		.header("Content-Type", "application.json")
		.contentType(ContentType.JSON)
		.when()
		.get()//Since am getting only the baseurl
		.then()
		.body("data.playerMinHeight",equalTo(6.2F));


		Float object = get().getBody().jsonPath().getJsonObject("data.playerMinHeight");
		System.out.println(object);
	}

	@Test
	public void check_responseTime(){
		baseURI ="http://localhost:3000/Indo-Pak-Series/";

		given()
		.header("Content-Type", "application.json")
		.contentType(ContentType.JSON)
		.when()
		.get()//Since am getting only the baseurl
		.then()
		.time(lessThan(1L),TimeUnit.SECONDS);

		Long responseTime =	 get().timeIn(TimeUnit.MILLISECONDS);
		System.out.println(responseTime);
	}


	@Test
	public void check_arrayEntries(){
		baseURI ="http://localhost:3000/Indo-Pak-Series/";

		given()
		.header("Content-Type", "application.json")
		.contentType(ContentType.JSON)
		.when()
		.get()//Since am getting only the baseurl
		.then()
		
		.body("games", hasSize(3));

	}

	@Test
	public void check_PlayerName(){

		baseURI ="http://localhost:3000/Indo-Pak-Series/";
		given()
			.header("Content-Type", "application.json")
			.contentType(ContentType.JSON)
		.when()
			.get()//Since am getting only the baseurl
		.then()
			.body("teams[0].players[4].playerName",equalTo("Yuvaraj"));
	}



}
