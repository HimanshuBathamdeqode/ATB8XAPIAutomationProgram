package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_015TestNG_DependsOnMEthod {

    @Test
    public void serverStartedOK(){

        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOK")  //Pehle upar vala chalega fir niche vala. Verna vaise to alpbhabetically chalta he.
    public void method1(){

        System.out.println("method1");
        Assert.assertTrue(true);

    }
}
