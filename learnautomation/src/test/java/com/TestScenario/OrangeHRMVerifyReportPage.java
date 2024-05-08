package com.TestScenario;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Parameters;
import com.page.OrangeHRMLeavePage;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import com.aventstack.extentreports.reporter.configuration.Theme;

import com.page.OrangeHRMLoginPage;
import com.page.OrangeHRMPimPage;
import com.page.OrangeHRMLeavePage;
// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.Status;
// import com.aventstack.extentreports.markuputils.ExtentColor;
// import com.aventstack.extentreports.markuputils.MarkupHelper;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// //import com.aventstack.extentreports.reporter.configuration.ChartLocation;
// import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMVerifyReportPage {
    WebDriver driver;
  
    // ExtentSparkReporter htmlReporter;
    // ExtentReports extent;

    // //helps to generate the logs in test report.
    // ExtentTest test;

    // @BeforeTest
    // public void startReport(String OS, String browser) {
    //     // initialize the HtmlReporter
    //     htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
    //     //initialize ExtentReports and attach the HtmlReporter
    //     extent = new ExtentReports();
    //     extent.attachReporter(htmlReporter);
    //     //To add system or environment info by using the setSystemInfo method.
    //     extent.setSystemInfo("OS", "Linux");
    //     extent.setSystemInfo("Browser", "Chrome");
    //     //configuration items to change the look and feel
    //     //add content, manage tests etc
    //     //htmlReporter.config().setChartVisibilityOnOpen(true);
    //     htmlReporter.config().setDocumentTitle("Extent Report Demo");
    //     htmlReporter.config().setReportName("Test Report");
    //     //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    //     htmlReporter.config().setTheme(Theme.STANDARD);
    //     htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    // }

    @BeforeMethod
    public void intilizeSetup() {
        // test = extent.createTest("Test Case 1", "PASSED test case");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login("Admin", "admin123");
        // Assert.assertTrue(true);
        //driver.close();
    }

    @Test
    public void loginPage()  {
        // test = extent.createTest("Test Case 2", "PASSED test case");
       // OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        //orangeHRMLoginPage.login("Admin", "admin123");
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/screenshot/screen1.png");
        // test.log(Status.INFO, "login successfully");
        // test.log(Status.PASS,"Test Passes");
        String expectedElement = "Dashboard";
        WebElement originalEle = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        String originalElement = originalEle.getText();
        // Assert.assertTrue(true);
        driver.close();
        try {
            FileHandler.copy(source, dest);
            Thread.sleep(4000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Test
    public void AddPIMUserAndLogout()  {
        // test = extent.createTest("Test Case 3", "PASSED test case");
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login("Admin", "admin123");
        OrangeHRMPimPage orangeHRMPimPage = new OrangeHRMPimPage(driver);
        orangeHRMPimPage.enterDetalis("Mr", "Vivek");
        // Assert.assertTrue(true);
        driver.close();
    }

    // @Test
    // public void ScreenShot() throws IOException{
    // TakesScreenshot screenshot = (TakesScreenshot)driver;
    // File source = screenshot.getScreenshotAs(OutputType.FILE);
    // FileUtils.copyFile(source,new File
    // ("/home/headrun/vs_automationDemo/learnautomation/src/test/java/com/Screenshot/screen.png"));
    // }

   @Test
   public void leaveApply(){
    OrangeHRMLeavePage lv = new OrangeHRMLeavePage(driver);
    lv.leave("2024-10-05", "2024-15-05", "I am going to outside");
   }

    @AfterMethod
    public void afterTest() {
       // driver.quit();
    }
}