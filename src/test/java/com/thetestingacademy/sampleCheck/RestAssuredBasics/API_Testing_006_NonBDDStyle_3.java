package com.thetestingacademy.sampleCheck.RestAssuredBasics;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_006_NonBDDStyle_3 {

    String payload = "{\n" +
            "                 \"username\" : \"admin\",\n" +
            "                 \"password\" : \"password123\"\n" +
            " }";

    RequestSpecification r = RestAssured.given();


    public void test_NonBDD_Post () {

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON)
                .log().all().body(payload);
        r.when().post();
        r.then().log().all().statusCode(200);
    }
}
