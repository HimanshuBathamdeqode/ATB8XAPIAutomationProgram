package com.thetestingacademy.sampleCheck.RestAssuredBasics;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_006_NonBDDStyle {

    @Test

    public void test_NonBDDSTyleGET () {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/462046");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}
