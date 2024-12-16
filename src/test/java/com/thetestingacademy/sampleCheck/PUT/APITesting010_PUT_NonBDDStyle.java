package com.thetestingacademy.sampleCheck.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUT_NonBDDStyle {

RequestSpecification requestSpecification ;

    // public void get_token(
    //{}
    //public void get_booking_id(){
    // Return bookingid;
    //       }

    @Description("Verify the PUT Request for the Restful Booker APIs")
    @Test


    public void test_put_non_bdd(){
       //Booking ID = 4945
        // Token
        // Token = 9486c16e7713523
//        {
//            "firstname" : "James",
//                "lastname" : "Brown",
//                "totalprice" : 111,
//                "depositpaid" : true,
//                "bookingdates" : {
//            "checkin" : "2018-01-01",
//                    "checkout" : "2019-01-01"
//        },
//            "additionalneeds" : "Breakfast"
//        }

        String token = "5dedb841c7a8adf";
        String bookingid = "1484";
        String payloadPUT = "{\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\" }";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/ ");
        requestSpecification.basePath("/booking/" +bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    // Three parts: RequestSpecification---> Response---> ValidateResponse
    }

}
