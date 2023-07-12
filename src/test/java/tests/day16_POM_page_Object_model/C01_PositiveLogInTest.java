package tests.day16_POM_page_Object_model;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C01_PositiveLogInTest {
    // 1) go to the "https://www.qualitydemy.com/
        /*
        2) click login button
        3) enter a valid email in emailTextBox  (valid email : a@a.com )
        4) enter a valid password in passwordTextBox ( Az.123123123 )
        5) click login button
        6) test that user could be able to login

         */

    @Test
    public void test01(){

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        //1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get("https://www.qualitydemy.com/");

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys("a@a.com");

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys("Az.123123123");

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

       //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.userHomePageMyCoursesButton.isDisplayed());

        Driver.closeDriver();

    }
}
