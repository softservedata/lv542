package com.softserve.edu.pageobject.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.econews.NewsComponent;

public class TipCardContainer {
    private final String TIP_CARD_COMPONENT_CSSSELECTOR = "????";

    private WebDriver driver;
    //
    private List<TipCardComponent> tipCardComponents;

    public TipCardContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        tipCardComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(TIP_CARD_COMPONENT_CSSSELECTOR))) {
            tipCardComponents.add(new TipCardComponent(current));
        }
    }

    // Page Object

    // Functional

    // Business Logic

}
