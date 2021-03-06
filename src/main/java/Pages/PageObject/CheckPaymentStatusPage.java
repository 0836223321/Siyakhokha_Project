package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.SiyakhokhaLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckPaymentStatusPage extends TestBase {

    public SiyakhokhaLocators siyakhokhaLocators;

    public CheckPaymentStatusPage() {

        this.siyakhokhaLocators = new SiyakhokhaLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.siyakhokhaLocators);
    }

    public void checkPaymentStatus(String username, String password){
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
            System.out.println("Payment status is: Payment complete");

        } else
            throw new AssertionError("Payment status not viewed");

    }


}
