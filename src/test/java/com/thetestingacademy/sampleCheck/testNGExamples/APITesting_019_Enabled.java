package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_019_Enabled {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(enabled = false)      //this will not run. It will be skipped.
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
