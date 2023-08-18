package com.virgingames.www.extractingResponseData;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExtractData {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI="https://www.virgingames.com";
        response= given()
                .when()
                .get("/api/jackpots/bingo?currency=GBP")
                .then().statusCode(200);
         //response.log().all(); //display all details

    }



    //This test extract All id.
    @Test
    public void test001()
    {
        List<Integer> id = response.extract().path("data.pots.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+id);
        System.out.println("------------------End of Test---------------------------");

    }

    //This Test Extract Name which id=309
    @Test
    public void test002()
    {
       String name =  response.extract().path("data.pots.findAll{it.id=='309'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void softAssert() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1),
                        "[0].firstName", equalTo("Vernon1"),
                        "[0].lastName", equalTo("Harper1"),
                        "[0].programme", equalTo("Financial Analysis1"));
    }
}
