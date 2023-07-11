package tests.day14_testng_framework;

import org.testng.annotations.Test;

public class C01_Priority {
    //TestNG
    @Test(priority = 17)
    public void firstTest(){
        System.out.println("First test is executed.");
    }

    @Test(priority = 10)
    public void secondTest(){
        System.out.println("Second test is executed.");
    }

    @Test(priority = 5)
    public void thirdTest(){
        System.out.println("Third test is executed.");
    }

}
