package com.TestScenario;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.page.OrangeHRMLoginPage;
import com.page.OrangeHRMPimPage;


public class ParallelTest {

    WebDriver driver;

    @Test(groups= {"SmokeTest"})
    public void loginPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login("Admin", "admin123");
        //ExtentTestManager.getTest().log(Status.INFO, "Test1, if 3<4..");
    }


   // @Test
    public void AddPIMUserAndLogout() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login("Admin", "admin123");

        OrangeHRMPimPage orangeHRMPimPage = new OrangeHRMPimPage(driver);
        orangeHRMPimPage.enterDetalis("Mr", "Vivek");
    }

    @AfterMethod
    public void afterTest() {
      driver.quit();
    }
    
}
