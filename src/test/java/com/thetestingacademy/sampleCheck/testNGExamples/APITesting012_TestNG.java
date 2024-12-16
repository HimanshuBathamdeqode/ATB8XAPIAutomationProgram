package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting012_TestNG {

@BeforeTest
    public void get_token(){

        System.out.println("1");
    }
@BeforeTest
    public void getBookingID(){

        System.out.println("2");

    }

    @Test               //To run above commands to get token and bookingid first we have to add "BeforeTest"
    public void test_PUt(){
         // token and booking ID
        System.out.println("3");


    }



}
