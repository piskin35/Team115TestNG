package tests.day18_Html_Reports_Parallel_Cross_DataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C05_WiseQuarterCrossTest extends TestBaseCross {

    @Test
    public void test(){
        driver.get("https://wisequarter.com");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));
    }

}
