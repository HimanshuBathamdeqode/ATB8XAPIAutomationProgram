package com.thetestingacademy.sampleCheck.payLoadMangement.Gson_easyway;

import com.thetestingacademy.sampleCheck.payLoadMangement.Gson_easyway.Bookingdates;
import com.thetestingacademy.sampleCheck.payLoadMangement.Gson_easyway.Booking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class POJO_easy_way {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq() {

        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;


            // {"firstname" : "Jim",
            //    "lastname" : "Brown",
            //    "totalprice" : 111,
            //    "depositpaid" : true
            //        "checkout" : "2019-01-01"
            //    },
            //    "additionalneeds" : "Breakfast"


            //POJO --> JSON

            com.thetestingacademy.sampleCheck.payLoadMangement.Gson_easyway.Booking booking = new Booking();
            booking.setFirstname("Jim");
            booking.setLastname("Brown");
            booking.setTotalprice(112);
            booking.setDepositpaid(true);

            Bookingdates bookingDates = new Bookingdates();
            bookingDates.setCheckin("2024-02-01");
            bookingDates.setCheckout("2024-02-01");
            booking.setBookingdates(bookingDates);
            booking.setAdditionalneeds("BreakFast");

            System.out.println(booking);


            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(booking).log().all();

            Response response = requestSpecification.when().post();

            Integer bookingId = response.then().extract().path(("bookingId"));

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);
            System.out.println("Your booking id is "  + bookingId );


        }
    }

