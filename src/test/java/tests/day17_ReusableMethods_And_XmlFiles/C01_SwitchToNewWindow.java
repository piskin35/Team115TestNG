package tests.day17_ReusableMethods_And_XmlFiles;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SwitchToNewWindow {

    // go to the https://the-internet.herokuapp.com/iframe
    // click on elemental selenium link
    // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
    // switch to new tab

    @Test
    public void test(){
        // go to the https://the-internet.herokuapp.com/iframe
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // click on elemental selenium link
        Driver.getDriver().findElement(By.xpath("//a[text()= 'Elemental Selenium']")).click();

        // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");

        ReusableMethods.waitFor(2);

        String expectedText = " weekly email of tips to help make";
        String actualText = Driver.getDriver().findElement(By.tagName("h2")).getText();

        Assert.assertEquals(expectedText,actualText);

        Driver.quitDriver();

        // switch to new tab
    }

}
