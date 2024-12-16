package com.thetestingacademy.sampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting014_TestNG_Groupism {


    @Test (groups = {"sanity", "qa" , "preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test (groups = {"qa", "prepod" , "reg"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"dev","stage"})
    public void somkeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);}

    @Test (groups = {"sanity", "qa" , "prepod"})
    public void sanityRun1(){
            System.out.println("Sanity");
            System.out.println("QA");
            Assert.assertTrue(true);}

    @Test(groups = {"smoke", "QA"})
    public void somkeRun3(){
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(true);
            }
        }

//Only Qa tag vale hi run hone jab testng-group-qa.xml file ko run karenge