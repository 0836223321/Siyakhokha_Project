package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.SiyakhokhaLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends TestBase {

    public SiyakhokhaLocators siyakhokhaLocators;

    public LoginPage() {

        this.siyakhokhaLocators = new SiyakhokhaLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.siyakhokhaLocators);
    }

    public void login(String username, String password){

        siyakhokhaLocators.systemLoginButton.click();
        siyakhokhaLocators.username.sendKeys(username);
        siyakhokhaLocators.password.sendKeys(password);
        siyakhokhaLocators.loginButton.click();
    }



}
