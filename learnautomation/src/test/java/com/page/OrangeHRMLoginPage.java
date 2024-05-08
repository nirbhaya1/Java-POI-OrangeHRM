package com.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;  
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class OrangeHRMLoginPage extends OrangeHRMBasePage{
  WebDriver driver;
    
    final String userName = "//input[@name='username']";
    final String userPassowrd = "//input[@name='password']";
    final String loginUser = "//button[normalize-space()='Login']";
    final String dashbaord = "//h6[normalize-space()='Dashboard']";
    //WebDriver driver;
    public OrangeHRMLoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = userName)
    private WebElement userNameElement;

    @FindBy(xpath = userPassowrd)
    private WebElement userPassWebElement;

    @FindBy(xpath = loginUser)
    private WebElement loginUserButton;

  @FindBy(xpath = dashbaord)
  private WebElement dashboardElement;


    public void login(String name, String password) {
      userNameElement.sendKeys(name);
      userPassWebElement.sendKeys(password);
      loginUserButton.click();
      File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File dest = new File(System.getProperty("user.dir") + "/sachinservices.png");
try {
	FileHandler.copy(source, dest);
} catch (Exception exception) {
	exception.printStackTrace();
}
    }}

    



