package com.thetestingacademy.sampleCheck;

import io.restassured.RestAssured;

public class APITest002 {
    public static void main(String[] args) {

        //Gherkin syntax
        // Full URL - https://restful-booker.herokuapp.com/booking
        // base URI - https://restful-booker.herokuapp.com
        // base Path - /booking/1
        RestAssured
                .given()
                     .baseUri("https://restful-booker.herokuapp.com")
                     .basePath("/booking/1")
                .when()
                    .get()
                .then().log().all()
                    .statusCode(200);  //.statusCode(200)For Positive test case it gives blank response for negative it gives
// Expected status code <200> but was <201>
    }
}
