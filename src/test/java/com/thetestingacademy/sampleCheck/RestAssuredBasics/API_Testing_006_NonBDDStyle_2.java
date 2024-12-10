package com.thetestingacademy.sampleCheck.RestAssuredBasics;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_006_NonBDDStyle_2 {

   static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
   @Description("TC1 - NonBDDStyleGet - Positive TestCase")
    @Test
    public void test_NonBDDStyleGET_Positive () {

        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/462046");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC2 - NonBDDStyleGet - Negative TestCase")
    @Test
    public void test_NonBDDSTyleGET_Negative () {

        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }
}
