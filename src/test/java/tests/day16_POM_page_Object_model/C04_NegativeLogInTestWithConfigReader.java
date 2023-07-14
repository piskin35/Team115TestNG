package tests.day16_POM_page_Object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLogInTestWithConfigReader {

    QualityDemyPage qualityDemyPage;

    @Test(priority = 1, groups = "reg1")
    public void invalidEmailTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));
        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }

    @Test(priority = 2, groups = "reg2")
    public void invalidPasswordTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));
        //4) enter a invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }

    @Test(priority = 3, groups = "smoke1")
    public void invalidPasswordInvalidEmailTest(){
        qualityDemyPage = new QualityDemyPage();
        //1) go to the "https://www.qualitydemy.com/
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));
        //2) click login button
        qualityDemyPage.homePageSignInButton.click();
        //3) enter a invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.logInPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));
        //4) enter a invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.logInPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));
        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();
        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());
        Driver.closeDriver();
    }
}
