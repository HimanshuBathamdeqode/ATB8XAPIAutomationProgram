package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.annotations.Test;

public class APITesting_020_InvocationCount {



    @Test (invocationCount = 5)
    public void test_01(){
        System.out.println("No. time user wants to run the code");
    }
}
