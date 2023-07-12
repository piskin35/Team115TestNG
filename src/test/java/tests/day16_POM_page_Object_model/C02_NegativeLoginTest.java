package tests.day16_POM_page_Object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C02_NegativeLoginTest {
    //1) test invalidEmail
    //2) test invalidPassword
    //3) test invalid email and password
    //HW:
    //5) space as charter
    //6) special characters
    //7) nothing we can send

    QualityDemyPage qualityDemyPage;

    @Test(priority = 1)
    public void invalidEmailTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get("https://www.qualitydemy.com/");
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys("qawsedrf@a.com");
        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys("Az.123123123");
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void invalidPasswordTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get("https://www.qualitydemy.com/");
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys("a@a.com");
        //4) enter a invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys("qwfe12rfeqf31");
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void invalidPasswordInvalidEmailTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get("https://www.qualitydemy.com/");
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys("qawsedrf@a.com");
        //4) enter a invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys("qwfe12rfeqf31");
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }
}
