package tests.day15_hard_soft_assert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C03_Soft_Assertion2 {

    // amazon.com
    // verify that you are in amazon.com
    // search for nutella and click on the firt product
    // verify that you searched for nutella
    // search for java
    // verify that there are more than 1000 results
    // close driver

    @Test
    public void test01(){

        // amazon.com
        Driver.getDriver().get("https://amazon.com");

        // verify that you are in amazon.com
        SoftAssert softAssert = new SoftAssert();
        String expectedUrlWord = "amazon.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlWord));

        // search for nutella and  verify that you searched for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        String expectedResultWord = "nutella";
        String actualResultTest = amazonPage.amazonResultText.getText();
        softAssert.assertTrue(actualResultTest.contains(expectedResultWord));

        // click on the first product
        amazonPage.firstProductOfSearch.click();

        // search for java
        amazonPage.amazonSearchBox.clear();
        amazonPage.amazonSearchBox.sendKeys("Java"+ Keys.ENTER);

        // verify that there are more than 1000 results
        String[] arr = amazonPage.amazonResultText.getText().split(" "); //1-48 of over 3,000 results for "Java"
        String numberStr = arr[3].replace(",", "");  //3,000 --> 3000

        int resultNumber = Integer.valueOf(numberStr);

        softAssert.assertTrue(resultNumber>1000);

        softAssert.assertAll();

        // close driver
        //Driver.getDriver().close();

        Driver.closeDriver();
    }
}
