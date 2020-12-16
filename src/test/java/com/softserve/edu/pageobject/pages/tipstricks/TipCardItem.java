package com.softserve.edu.pageobject.pages.tipstricks;

import org.openqa.selenium.WebElement;

public class TipCardItem {

    private WebElement tipCard;

    public TipCardItem(WebElement tipCard) {
        this.tipCard = tipCard;
        initElements();
    }

    private void initElements() {
    }
}
