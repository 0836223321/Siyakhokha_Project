package Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SiyakhokhaLocators {

    /*Login*/

    @FindBy(xpath = "//a[@href='/qa/Account/Login'][contains(.,'Log In')]")
    public WebElement systemLoginButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[contains(@id,'logout')]")
    public WebElement verifyLogin;

    @FindBy(xpath = "//a[contains(@id,'Manage Accounts')]")
    public WebElement manageAcc;

    /*Register*/

    @FindBy(xpath = "(//a[contains(.,'Register')])[1]")
    public WebElement systemRegister;

    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='IdentificationNumber']")
    public WebElement idNumber;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement regUsername;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement regPassword;

    @FindBy(xpath = "//input[contains(@id,'ConfirmPassword')]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='MobileNumber']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='ConfirmMobileNumber']")
    public WebElement confirmMobileNumber;

    @FindBy(xpath = "//input[@type='button']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement recaptcha;

    @FindBy(xpath = "//input[@id='box']")
    public WebElement checkBox;

    @FindBy(how = How.XPATH, using = "//*[text()='OK']")
    public WebElement verifyRegistrationText;


}
