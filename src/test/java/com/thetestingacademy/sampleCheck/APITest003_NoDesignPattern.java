package com.thetestingacademy.sampleCheck;

public class APITest003_NoDesignPattern {

    public void  step1(){
        System.out.println("Step 1");

    }

    public void step2(){

        System.out.println("Step 2");
    }
    public void step3(String pramod){

        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        APITest003_NoDesignPattern np = new APITest003_NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("pramod");

      //  np.step1().step2().step("pramod") --not possible in no design pattern

    }
}
