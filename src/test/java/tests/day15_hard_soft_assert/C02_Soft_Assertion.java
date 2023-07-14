package tests.day15_hard_soft_assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_Soft_Assertion {

    @Test(groups = "smoke1")
    public void test01(){

        //if we want to do soft assertion, we need to create an object from SoftAssert class

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(6>3);
        System.out.println("After first assertion");

        softAssert.assertTrue(6>5);
        System.out.println("After second assertion");

        softAssert.assertEquals(6,6);
        System.out.println("After third assertion");

        //to test soft assertions we need to assetAll() method, if not, it won test anything
        softAssert.assertAll();
        System.out.println("After assertAll");
    }

}
