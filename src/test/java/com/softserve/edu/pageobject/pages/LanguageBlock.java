package com.softserve.edu.pageobject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguageBlock {

    private WebDriver driver;
    private WebElement en;
    private WebElement ua;
    private WebElement ru;

    private List<WebElement> languages;

    public LanguageBlock(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        en = driver.findElement(By.xpath("//li[contains(text(),'En')]"));
        ua = driver.findElement(By.xpath("//li[contains(text(),'Ua')]"));
        ru = driver.findElement(By.xpath("//li[contains(text(),'Ru')]"));
        languages = new ArrayList<>();
        languages.add(en);
        languages.add(ua);
        languages.add(ru);
    }

    public void chooseEnglish() {
        en.click();
    }

    public void chooseUkrainian() {
        ua.click();
    }

    public void chooseRussian() {
        ru.click();
    }

    public void clickLanguageByName(String languageName) {
        for (WebElement currentLanguage : languages) {
            if (currentLanguage.getText().toLowerCase().contains(languageName.toLowerCase())) {
                currentLanguage.click();
                break;
            }
        }
    }
}