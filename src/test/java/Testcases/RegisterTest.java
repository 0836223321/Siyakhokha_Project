package Testcases;

import Base.TestBase;
import Listeners.ExtentReport;
import Pages.PageObject.RegisterPage;
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

public class RegisterTest extends TestBase {

    ExtentReport extentReport = new ExtentReport();

    @BeforeTest
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(("http://10.1.2.126/qa"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "ReadData")
    public void registerTest(Hashtable<String, String> data) throws InterruptedException, IOException {

        if (!data.get("Runmode").equals("Y")) {

            throw new SkipException("Skipped");
        }

        extentReport.start(data.get("Test_Case_Description"));

        try{
            RegisterPage registerPage = new RegisterPage();

            registerPage.registerOnSiyakhokha(data.get("First_Name"), data.get("Last_Name"), data.get("ID_Number"),
                    data.get("Reg_Username"), data.get("Password"), data.get("Confirm_Password"), data.get("Mobile_Number"),
                    data.get("Confirm_Mobile_Number"));

        }catch (Exception e){

            extentReport.failure(e.getMessage() + " " + "." +  "Expected results are: " +"  "+ data.get("Expected_Results"));
            Assert.assertFalse(isElementPresent(By.xpath("//*[text()='OK']")), "Unable to locate the element. System changed");

        }

        Assert.fail("Changes were performed on the system");
        extentReport.success("Successfully registered");

}

    @AfterTest
    public void tearDown() {
        extentReport.onFinish();
        driver.quit();
    }


    }

