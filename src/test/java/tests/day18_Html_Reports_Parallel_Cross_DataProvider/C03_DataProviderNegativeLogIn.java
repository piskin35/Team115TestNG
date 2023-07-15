package tests.day18_Html_Reports_Parallel_Cross_DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderNegativeLogIn {
    // 1) go to the QualityDemy homepage
    // 2) enter wrong password and username
    // 3) test that user can not login
    /*
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345
     */
    @DataProvider
    public static Object[][] provideUserNameAndPassword(){
        Object[][] userNameAndPassword = {{"A11", "A12345"},{"B12", "B12345"},{"C12", "C12345"},{"D12", "D12345"},{"E12", "E12345"}};

        return userNameAndPassword;
    }

    @Test(dataProvider = "provideUserNameAndPassword")
    public void test(String username, String password){
        // 1) go to the QualityDemy homepage
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) enter wrong password and username
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.homePageSignInButton.click();
        qualityDemyPage.logInPageEmailTextBox.sendKeys(username);
        qualityDemyPage.logInPagePasswordTextBox.sendKeys(password);
        qualityDemyPage.loginPageLoginButton.click();

        // 3) test that user can not login
        Assert.assertTrue(qualityDemyPage.enterYourValidCredText.isDisplayed());

        Driver.closeDriver();
    }

    //HW: Generate an HTML report for this test
}
