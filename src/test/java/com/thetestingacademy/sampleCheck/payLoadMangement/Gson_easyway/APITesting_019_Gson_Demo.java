package com.thetestingacademy.sampleCheck.payLoadMangement.Gson_easyway;
import com.google.gson.Gson;
import com.thetestingacademy.sampleCheck.payLoadMangement.difficultway.Booking;
import com.thetestingacademy.sampleCheck.payLoadMangement.difficultway.BookingDates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class APITesting_019_Gson_Demo {

RequestSpecification requestSpecification;
ValidatableResponse validatableResponse;

    // Step 1 - Post
    // URL --> Base URI +Base path
    // Header
    // Body
    // Auth - NO

    // Step 2
    // Prepare the Payload ( Convert your object to JSON string )
    // Send the request


    // Step 3
    // Validate response ( JSON String to Object ) It is very difficult to validate a string.
    // FirstName,
    // Status code
    // Time Response

            @Test
            public  void testPositive() {

        com.thetestingacademy.sampleCheck.payLoadMangement.difficultway.Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("BreakFast");

        System.out.println(booking);

        Gson gson = new Gson();
        // Object -> JSON String (GSON)  --
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);


                requestSpecification = RestAssured.given();
                requestSpecification.baseUri("https://restful-booker.herokuapp.com");
                requestSpecification.basePath("booking");
                requestSpecification.contentType(ContentType.JSON);
                requestSpecification.body(jsonStringBooking).log().all();

                Response response = requestSpecification.when().post();
                String jsonResponseString = response.asString();  //serialization


                validatableResponse = response.then().log().all();
                validatableResponse.statusCode(200);

                //To verify response---either extract() or jsonPath.getString()-- Good only when response is small.
                    // Response has complex json or huge json then we need to convert string to object which is called deserialization.

                    // Now De ser - de serialization

                    BookingResponse bookingResponse = gson.fromJson(jsonResponseString,BookingResponse.class);
                    assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
                    assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim").isNotNull().isNotEmpty();







            }
}
