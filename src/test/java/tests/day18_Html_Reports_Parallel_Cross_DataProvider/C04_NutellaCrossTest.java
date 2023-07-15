package tests.day18_Html_Reports_Parallel_Cross_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C04_NutellaCrossTest extends TestBaseCross {

    @Test
    public void test01(){

        driver.get(ConfigReader.getProperty("amazonUrl"));
        WebElement amazonSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement amazonResultext = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        String actualResultText = amazonResultext.getText();
        String expectedResultWord = "Nutella";
        Assert.assertTrue(actualResultText.contains(expectedResultWord));



    }
}
