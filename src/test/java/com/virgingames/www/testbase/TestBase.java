package com.virgingames.www.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase
{
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com";
        //RestAssured.port = 8080;
        RestAssured.basePath = "/api/jackpots/bingo?currency=GBP";
    }
}
