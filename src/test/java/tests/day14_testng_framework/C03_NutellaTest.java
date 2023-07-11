package tests.day14_testng_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTest {

    @Test
    public void test01(){

        //Driver set up
        Driver.getDriver().get("Https://amazon.com");

        //we need to create object from the page that we want to use their webElement
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.amazonSearchBox.sendKeys("Nutella" + Keys.ENTER);

        String expectedResultWord = "Nutella";
        String actualResultText = amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultWord));




    }
}
