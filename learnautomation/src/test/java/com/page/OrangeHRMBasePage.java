package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMBasePage {

    final String userProfileTab=".oxd-userdropdown-tab";
    final String logoutUser = " //a[normalize-space()='Logout']";

     public OrangeHRMBasePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = logoutUser)
    private WebElement logoutUserElement;

    @FindBy(css=userProfileTab)
    private WebElement userProfileButton;

    public void logout(){

        userProfileButton.click();
        logoutUserElement.click();
  
      }
    
}
