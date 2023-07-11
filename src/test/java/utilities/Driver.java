package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        return driver;
    }

    // to close opened driver // if a driver is opened, this method will close it. If there is no drider, it wont do anything
    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null;
        }

    }

    public static void quitDriver(){

        if (driver!=null) {
            driver.quit();
            driver=null;
        }

    }
}
