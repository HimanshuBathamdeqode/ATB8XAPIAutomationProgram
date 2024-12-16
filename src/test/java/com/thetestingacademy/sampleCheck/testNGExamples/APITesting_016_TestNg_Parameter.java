package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_016_TestNg_Parameter {

    @Parameters("browser")   // xml file me naam "browser" diya he
    @Test
    void demo1(String value) {

        System.out.println("Browser is " + value);
        // Open the Browser and Select data
        {
            if (value.equalsIgnoreCase("chrome")) ;
            {
                System.out.println("Start my testing");
            }

            if (value.equalsIgnoreCase("firefox")) ;
                {
                    System.out.println("Start my firefox");
                }

            }
        }
    }
