package tests.day15_hard_soft_assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_Soft_Assertion3 {
    //Create a New Class: C03_SoftAssert
    //1. Go to “http://zero.webappsecurity.com/”
    //2. Press the Sign in button
    //3. Type “username” in the login box
    //4. Type “password” in the Password box
    //5. Press the Sign in button
    //6. Go to the Pay Bills page in the online banking menu
    //7. Press the “Purchase Foreign Currency” key
    //8. Select Eurozone from the “Currency” drop down menu
    //9. Test that "Eurozone (euro)" is selected using soft assert
        /*
        10. Test that the DropDown list has these options using soft assert "Select One",
        "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        "Denmark (krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
        "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden (krona)",
        "Singapore (dollar)","Thailand (baht)"
         */

    @Test(groups = "reg2")
    public void test01() throws InterruptedException {
        //1. Go to “http://zero.webappsecurity.com/”
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        //2. Press the Sign in button
//        WebElement signInBUtton = Driver.getDriver().findElement(By.id("signin_button"));
//        signInBUtton.click();   -----------This Steps works but it is not proper for TestNG
        ZeroPage zeroPage = new ZeroPage(); //I have created Zero page object to be able to call the variables
        zeroPage.SignInButton.click();

        //3. Type “username” in the login box
        zeroPage.LogInPageUserTextBox.sendKeys("username");

        //4. Type “password” in the Password box
        zeroPage.LogInPagePasswordTextBox.sendKeys("password");

        //5. Press the Sign in button
        zeroPage.logInPageSignInButton.click();
        Driver.getDriver().navigate().back();//curent page is giving an error that's why we go back to previous page

        //6. Go to the Pay Bills page in the online banking menu
        zeroPage.onlineBankingMenuButton.click();
        zeroPage.payBillLinkButton.click();

        //7. Press the “Purchase Foreign Currency” key
        zeroPage.PurchaseForeignCurrencyLink.click();
        Thread.sleep(3000);

        //8. Select Eurozone from the “Currency” drop down menu
        Select select = new Select(zeroPage.payBillsCurrencyDropDown);

        select.selectByVisibleText("Eurozone (euro)");

        //9. Test that "Eurozone (euro)" is selected using soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(select.getFirstSelectedOption().isDisplayed());

        /*
        10. Test that the DropDown list has these options using soft assert "Select One",
        "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        "Denmark (krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
        "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden (krona)",
        "Singapore (dollar)","Thailand (baht)"
         */

        List<WebElement> listOfDropDownOptions = select.getOptions();
        List<String> actualOptionList = new ArrayList<>();

        String textOfEachWebElement = "";

        for (WebElement each: listOfDropDownOptions) {
            textOfEachWebElement = each.getText();
            actualOptionList.add(textOfEachWebElement);
        }

        String[] arr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionList = Arrays.asList(arr);
        softAssert.assertEquals(actualOptionList, expectedOptionList);

        System.out.println(actualOptionList);
        System.out.println(expectedOptionList);

        softAssert.assertAll();

        Driver.closeDriver();

    }
}
