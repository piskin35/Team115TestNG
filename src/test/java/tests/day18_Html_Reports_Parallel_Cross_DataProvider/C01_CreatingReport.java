package tests.day18_Html_Reports_Parallel_Cross_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_CreatingReport extends TestBaseReport {

    // 1) go to the amazon.com
    // 2) Search for nutella
    // 3) Test that result text has nutella


    @Test
    public void test01(){


        extentTest = extentReports.createTest("Amazon Nutella Test", "User should be able to search for nutella");
        // 1) go to the amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("user reached amazon website");

        // 2) Search for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys(ConfigReader.getProperty("amazonWordToSearch") + Keys.ENTER);
        extentTest.info("User searched nutella");

        // 3) Test that result text has nutella
        String expectedResult = ConfigReader.getProperty("amazonWordToSearch");
        String actualResult = amazonPage.amazonResultText.getText();
        extentTest.info("System saved the result");

        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("Tested that result contains the word");
    }

}
