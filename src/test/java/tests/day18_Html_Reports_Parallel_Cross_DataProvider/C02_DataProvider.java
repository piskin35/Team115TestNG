package tests.day18_Html_Reports_Parallel_Cross_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {


    @DataProvider
    public static Object[][] wordsToSearchInAmazon() {

        Object[][] wordsToSearchInAmazonArray = {{"nutella"}, {"java"}, {"samsung"}, {"iphone"}, {"Cokokrem"}};

        return wordsToSearchInAmazonArray;
    }

    @Test(dataProvider = "wordsToSearchInAmazon")
    public void test01(String wordToSearch){

        // 1) go to the amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // 2) Search for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys(wordToSearch + Keys.ENTER);

        // 3) Test that result text has nutella
        String expectedResult = wordToSearch;
        String actualResult = amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
