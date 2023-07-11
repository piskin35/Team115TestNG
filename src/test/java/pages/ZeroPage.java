package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="signin_button")
    public WebElement SignInButton;

    @FindBy(id = "user_login")
    public WebElement LogInPageUserTextBox;

    @FindBy(id = "user_password")
    public WebElement LogInPagePasswordTextBox;

    @FindBy(name = "submit")
    public WebElement logInPageSignInButton;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenuButton;

    @FindBy(id= "pay_bills_link")
    public WebElement payBillLinkButton;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement PurchaseForeignCurrencyLink;

    @FindBy(id = "pc_currency")
    public WebElement payBillsCurrencyDropDown;

}
