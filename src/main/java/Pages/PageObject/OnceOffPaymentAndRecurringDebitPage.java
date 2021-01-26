package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.SiyakhokhaLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OnceOffPaymentAndRecurringDebitPage extends TestBase {

    public SiyakhokhaLocators siyakhokhaLocators;

    public OnceOffPaymentAndRecurringDebitPage() {

        this.siyakhokhaLocators = new SiyakhokhaLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.siyakhokhaLocators);
    }

    public void onceOffAndRecurringDebit(String username, String password) {
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
            System.out.println("Debit order successfully created");

        } else
            throw new AssertionError("Debit order not created");

    }
}
