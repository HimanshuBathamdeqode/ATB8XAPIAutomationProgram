package com.thetestingacademy.sampleCheck.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;

public class APITesting013_Assertions_Real_examples {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    //Post --> Create ---> Verify the response

    public void test_post() {

        String payload_POST = "{\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\" }";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/ ");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();


        // Get Validatable response to perform validation
        ValidatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Validatable Response  - By default installed by hamcrest in  Rest Assured.


        validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo("false"));
        validatableResponse.body("bookingid", Matchers.notNullValue());

         //But we will avoid above methods. Below testng is good

        // TestNG Assertions
        // soft assert vs hard assert
        // This means that if any assertion fails, the remaining statements in that test method will not be executed.

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname") ;
        String lastname = response.then().extract().path("booking.lastname") ;
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "Jim");
        Assert.assertEquals(lastname,"Brown");


        // Assertj(3rd party library to assertion -Very good results)

        assertThat(bookingId).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isEqualTo("Jim").isNotNull().isNotEmpty().isAlphanumeric();



    
    }
}
