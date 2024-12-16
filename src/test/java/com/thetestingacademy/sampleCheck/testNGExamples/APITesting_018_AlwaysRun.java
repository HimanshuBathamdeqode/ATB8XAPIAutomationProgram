package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_018_AlwaysRun {

    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)      //this will always run.
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }

}


// Ideally we need to create xml files for every class examples.