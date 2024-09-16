package com.softserve.edu.pageobject.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TipCardContainer {
    private final String TIP_CARD_COMPONENT_CSSSELECTOR = "????"; //TODO
    private WebDriver driver;
    private List<TipCardItem> tipCardItems;

    public TipCardContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        tipCardItems = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(TIP_CARD_COMPONENT_CSSSELECTOR))) {
            tipCardItems.add(new TipCardItem(current));
        }
    }
}
