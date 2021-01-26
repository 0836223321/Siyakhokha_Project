package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.SiyakhokhaLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage extends TestBase {

    public SiyakhokhaLocators siyakhokhaLocators;

    public RegisterPage() {

        this.siyakhokhaLocators = new SiyakhokhaLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.siyakhokhaLocators);
    }

    public void registerOnSiyakhokha(String firstName, String lastName, String idNumber, String regUsername, String regPassword,
                                     String confirmPassword, String mobileNumber, String confirmMobileNumber){

        siyakhokhaLocators.systemRegister.click();
        siyakhokhaLocators.firstName.sendKeys(firstName);
        siyakhokhaLocators.lastName.sendKeys(lastName);
        siyakhokhaLocators.idNumber.sendKeys(idNumber);
        siyakhokhaLocators.regUsername.sendKeys(regUsername);
        siyakhokhaLocators.regPassword.sendKeys(regPassword);
        siyakhokhaLocators.confirmPassword.sendKeys(confirmPassword);
        siyakhokhaLocators.mobileNumber.sendKeys(mobileNumber);
        siyakhokhaLocators.confirmMobileNumber.sendKeys(confirmMobileNumber);
        siyakhokhaLocators.recaptcha.click();
        siyakhokhaLocators.registerButton.click();








    }


}
