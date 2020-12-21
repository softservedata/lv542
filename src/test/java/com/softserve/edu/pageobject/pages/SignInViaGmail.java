package com.softserve.edu.pageobject.pages;

import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignInViaGmail extends TopPart{
    private WebElement choseAccount;
    public SignInViaGmail(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements() {
        choseAccount=driver.findElement(By.xpath("//*[@class='kHn9Lb']"));
    }
    public void waitUntilElementLocated(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getWindowHandles().size()>1;
            }
        }
        );
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Set<String> handles = driver.getWindowHandles();
        for (String currentWindow: handles){
            driver.switchTo().window(currentWindow);
            if (driver.getCurrentUrl().contains("accounts.google.com")){
                break;
            }
        }
    }
    public WebElement getChoseAccount(){
        return choseAccount;
    }
    public MyHabitsPage getChoseAccountText(){
        waitUntilElementLocated();
        getChoseAccount().getText().trim();
        return new MyHabitsPage(driver);
    }
}
