package tests.day15_hard_soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_HardAssert {


    /*
    There are two different assertion types

    1-) Hard Assertion:
    When we use hard assertion, code will be executed until the first failure. At the first failure system will
    stop and won't execute next line. In the console we will see the messages for the first failure

    2-) Soft Assertion


     */

    @Test(groups = "reg1")
    public void test01(){
        Assert.assertTrue(10>7);
        System.out.println("after first assert");

        Assert.assertTrue(6>3);
        System.out.println("after Secondassert");

        Assert.assertEquals(6,6);
        System.out.println("after third assert");
    }
}
