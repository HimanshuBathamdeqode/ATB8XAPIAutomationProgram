package com.thetestingacademy.sampleCheck;

public class APITest004_BuilderDesignPattern {

    //Change return type of each method as Class type
    //"this" always point to Current/calling object. Returning the same to
    // have same reference

    public APITest004_BuilderDesignPattern step1 (){
        System.out.println("Step 1 is started");
        System.out.println("Step 1 Done");
        return this;
    }

    public APITest004_BuilderDesignPattern step2(){
        System.out.println("Step 2 is started");
        System.out.println("Step 2 Done" );
        return this;
    }

    public APITest004_BuilderDesignPattern step3 (String name){
        System.out.println("Step 3 is started");
        System.out.println("Step 3 Done" + name);
        return this;
    }

    public static void main(String[] args) {
        APITest004_BuilderDesignPattern bp = new APITest004_BuilderDesignPattern();
        bp.step1().step2().step3("Pramod");
    }
}
