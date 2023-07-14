package tests.day14_testng_framework;

import org.testng.annotations.Test;

public class C02_DependsOnMethod {

    @Test(groups = "reg1")
    public void firstTest(){
        System.out.println("First test is executed");
    }

    @Test(dependsOnMethods = "firstTest")
    public void secondTest(){
        System.out.println("Second test is executed");
    }

    @Test(dependsOnMethods = "secondTest")
    public void thirdTest(){
        System.out.println("Third test is executed");
    }


    // ***"dependsOnMethods" this can go only one before

}
