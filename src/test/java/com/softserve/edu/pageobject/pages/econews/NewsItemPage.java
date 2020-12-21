package com.softserve.edu.pageobject.pages.econews;

import com.softserve.edu.pageobject.pages.places.FiltersSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.pageobject.pages.TopPart;
import org.openqa.selenium.WebElement;

/**
 * A template class for News Page
 */
public class NewsItemPage extends TopPart {

    private WebElement backToNewsButton;

    public NewsItemPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        backToNewsButton = driver.findElement(By.xpath("//div[@class='button-text']"));
        // init elements
    }

    // Page Object
    public FilterBlock activateBackToNewsButton() {
        backToNewsButton.click();
        return new FilterBlock(driver);
    }

}
