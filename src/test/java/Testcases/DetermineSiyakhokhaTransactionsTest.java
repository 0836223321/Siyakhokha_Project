package Testcases;

import Base.TestBase;
import Listeners.ExtentReport;
import Pages.PageObject.DetermineTransactionPage;
import Utilities.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class DetermineSiyakhokhaTransactionsTest extends TestBase {

    ExtentReport extentReport = new ExtentReport();

    @BeforeTest
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(("http://10.1.2.126/qa"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "ReadData")
        public void determineTransactionsTest(Hashtable<String, String> data) throws InterruptedException, IOException {

        if (!data.get("Runmode").equals("Y")) {

            throw new SkipException("Skipped");
        }

        extentReport.start(data.get("Test_Case_Description"));

        try{
            DetermineTransactionPage determineTransactionPage = new DetermineTransactionPage();
            determineTransactionPage.determineTransactions(data.get("Username"), data.get("Password"));

        }catch (Exception e){

            extentReport.failure("Transaction not executed." + "  " + " " +" "+ "Expected Results Are:" +"  "+ data.get("Expected_Results"));
            Assert.assertFalse(isElementPresent(By.id("Services")), "Unable to locate the element. System changed");
        }

        Assert.fail("Services button not available. System changed");
        extentReport.success("Transaction successfully executed");

    }

    @AfterTest
    public void tearDown() {
        extentReport.onFinish();
        driver.quit();
    }



}
