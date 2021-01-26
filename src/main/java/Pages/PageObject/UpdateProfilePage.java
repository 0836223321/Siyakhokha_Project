package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.SiyakhokhaLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class UpdateProfilePage extends TestBase {

    public SiyakhokhaLocators siyakhokhaLocators;

    public UpdateProfilePage() {

        this.siyakhokhaLocators = new SiyakhokhaLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.siyakhokhaLocators);
    }

    public void updateProfile(String username, String password){

        try {
            siyakhokhaLocators.systemLoginButton.click();
            siyakhokhaLocators.username.sendKeys(username);
            siyakhokhaLocators.password.sendKeys(password);
            siyakhokhaLocators.loginButton.click();

            siyakhokhaLocators.manageAcc.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
        if (siyakhokhaLocators.manageAcc.isDisplayed()) {
            System.out.println("Profile updated successfully");

        } else
            throw new AssertionError("Failed to update profile");

    }

}
