package com.page;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLeavePage extends OrangeHRMBasePage {
    WebDriver driver;
    final String leave = "//span[normalize-space()='Leave']";
    final String apply_linktext = "Apply";
    final String leave_type = "i[@class = 'oxd-icon bi-caret-down-fill oxd-select-text--arrow']";
    //final String from_date = "(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]";
    final String from_date = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]";
    //final String to_date = "(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]";
    final String to_date = "(//input[@placeholder='yyyy-dd-mm'])[2]";
    final String comments = "(//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]";
    final String apply = "//button[normalize-space()='Apply']";



    public OrangeHRMLeavePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    //Select dropdown = new Select(leave_type);


    @FindBy(xpath = leave)
    private WebElement leaveElement;

    @FindBy(linkText = apply_linktext)
    private WebElement linkTextElement;

    @FindBy(xpath = leave_type)
    private WebElement leave_typeElement;

    @FindBy(xpath = from_date)
    private WebElement from_dateElement;

    @FindBy(xpath = to_date)
    private WebElement to_dateElement;

    @FindBy(xpath = comments)
    private WebElement commentsElement;

    @FindBy(xpath = apply)
    private WebElement applyElement;


    public void selectLeaveType(String leaveType)
    {
        driver.findElement(By.cssSelector(".oxd-form-row .oxd-select-text--after")).click();
        //driver.findElement(By.xpath("//div[@role='listbox']//span[normalize-space()='CAN - FMLA']")).click();
        driver.findElement(By.xpath("//div[@role='listbox']//span[normalize-space()='" +leaveType+"']")).click();
    }

    public void leave(String fromdate, String todate, String comment){
        leaveElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(linkTextElement));
        linkTextElement.click();

        selectLeaveType("CAN - FMLA");
        
        from_dateElement.clear();
        from_dateElement.sendKeys(fromdate);   //fromDateTextBox
        to_dateElement.click();
        to_dateElement.sendKeys(Keys.CONTROL + "a",Keys.DELETE);
        to_dateElement.sendKeys(todate);
        commentsElement.sendKeys(comment);
        applyElement.click();
        
       // applyElement.click();
       //.oxd-form-row .oxd-select-text--after
       ////div[@class='oxd-form-row']  //div[@class='oxd-select-text--after']


    }

    
}
