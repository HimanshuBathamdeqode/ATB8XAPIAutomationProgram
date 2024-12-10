package com.thetestingacademy.sampleCheck.RestAssuredBasics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Testing_005_BDDStyleGET {

    @Test

    public void  test_GET_Req_POSITIVE() {

        String pin_code = "462042";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/"+pin_code)

                .when()
                     .log()
                     .all()
                .then()
                     .log().all()
                     .statusCode(200);
    }
}
