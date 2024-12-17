package com.thetestingacademy.sampleCheck.payLoadMangement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_016_Payload_Map {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test

    public void testPOSTReq( ) {
        // {"firstname" : "Jim",                          ------First curly braces
        //    "lastname" : "Brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {                          -------Second curly braces
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
//        }



        // Json to Hashmap conversion                         ---------- So we have to make to hashmaps

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();   //--First
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", "111");
        jsonBodyUsingMap.put("depositpaid", "true");

        Map<String, Object> bookingDatesMap = new LinkedHashMap();     // --second
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates","bookingDatesMap");
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap );     //   GSON or jackson API can convert it

        //Below is the method


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path(("bookingId"));

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your booking id is" + bookingId);





    }
}
