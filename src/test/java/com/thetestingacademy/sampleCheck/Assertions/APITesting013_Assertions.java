package com.thetestingacademy.sampleCheck.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting013_Assertions {

    // Testng assertions
    // Expected result = Actual result


//    @Test
//    public void test_hardassertionsexample(){
//        System.out.println("Start of the program");
//        Assert.assertTrue(false);
//        System.out.println("End of the program");
//    }


    @Test
    public void test_softassertionsexample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);  // This will not stop executing code
        System.out.println("This line will be executed");
        softAssert.assertAll();

    }
}
