package com.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class OrangeHRMPimPage extends OrangeHRMBasePage{

    WebDriver driver;

    final String pimEle = "//ul[@class='oxd-main-menu'] //span[text()='PIM']";
    final String addDetalis = "//button[normalize-space()='Add']";
    final String firstName = "//input[@name='firstName']";
    final String lastName = "//input[@name='lastName']";
    final String saveDetalis = "//button[normalize-space()='Save']";
    final String verifyDetails = ".orangehrm-edit-employee-name>h6";
    final String verifyDetails1="//div[@class='orangehrm-edit-employee-name']/h6";



    public OrangeHRMPimPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = pimEle)
    private WebElement pWebElement;

    @FindBy(xpath = addDetalis)
    private WebElement addDetailsElement;

    @FindBy(xpath = firstName)
    private WebElement firstNameElement;

    @FindBy(xpath = lastName)
    private WebElement lastNameElement;

    @FindBy(xpath = saveDetalis)
    private WebElement saveDetailsElement;

    @FindBy(css = verifyDetails)
    private WebElement verifyDetalisElement;
    
    
    public void enterDetalis(String first, String last){
        pWebElement.click();
        addDetailsElement.click();
        firstNameElement.sendKeys(first);
        lastNameElement.sendKeys(last);
        saveDetailsElement.click();

        By.xpath(verifyDetails1);

        /*
        try{

            Thread.sleep(10000);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        */

        By successMsgPopup = By.id("oxd-toaster_1");
        By spinner=By.cssSelector(".oxd-loading-spinner");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(successMsgPopup));
    


       // ExpectedConditions.textToBe(By.xpath(verifyDetails1), first+" "+last);
        Assert.assertEquals(verifyDetalisElement.getText().trim(), first+" "+last);

        logout();

}
}