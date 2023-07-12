package tests.day16_POM_page_Object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLogInTestWithConfigReader {

    @Test
    public void test01(){

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        //1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.userHomePageMyCoursesButton.isDisplayed());

        Driver.closeDriver();

    }
}
