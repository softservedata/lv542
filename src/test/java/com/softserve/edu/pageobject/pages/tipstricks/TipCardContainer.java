package com.softserve.edu.pageobject.pages.tipstricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TipCardContainer {
    private WebDriver driver;

    public TipCardContainer(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getBottleImage() {
        return driver.findElements(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-duplicate swiper-slide-prev']//img"));
    }

    public List<WebElement> getSpoonForkKnifeImage() {
        return driver.findElements(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-active ng-star-inserted']//img"));
    }

    public List<WebElement> getCoffeCupImage() {
        return driver.findElements(By
                .xpath("//app-tips-card[@class='swiper-slide ng-star-inserted']//img"));
    }

    public WebElement getLeftTipCardParagraph() {
        return driver.findElement(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-duplicate swiper-slide-prev']//p"));
    }

    public WebElement getMiddleTipCardParagraph() {
        return driver.findElement(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-active ng-star-inserted']//p"));
    }

    public WebElement getMiddleTipCardParagraphAfterRightButtonClick() {
        return driver.findElement(By
                .xpath("//app-tips-card[@class='swiper-slide ng-star-inserted swiper-slide-active']//p"));
    }

    public WebElement getMiddleTipCardParagraphAfterLeftButtonClick() {
        return driver.findElement(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-duplicate swiper-slide-active']//p"));
    }

    public WebElement getRightTipCardParagraph() {
        return driver.findElement(By
                .xpath("//app-tips-card[@class='swiper-slide swiper-slide-next ng-star-inserted']//p"));
    }

    public String getMiddleTipCardParagraphTextAfterLeftButtonClick() {
        return getMiddleTipCardParagraphAfterLeftButtonClick().getText();
    }

    public String getMiddleTipCardParagraphTextAfterRightButtonClick() {
        return getMiddleTipCardParagraphAfterRightButtonClick().getText();
    }

    public String getMiddleTipCardParagraphText() {
        return getMiddleTipCardParagraph().getText();
    }

    public boolean isBottleImagePresent() {
        return !getBottleImage().isEmpty();
    }

    public boolean isSpoonForkKnifeImagePresent() {
        return !getSpoonForkKnifeImage().isEmpty();
    }

    public boolean isCoffeCupImagePresent() {
        return !getCoffeCupImage().isEmpty();
    }

    public boolean isLeftTipCardParagraphPresent() {
        return getLeftTipCardParagraph().getText().length() > 0;
    }

    public boolean isMiddleTipCardParagraphPresent() {
        return getMiddleTipCardParagraph().getText().length() > 0;
    }

    public boolean isRightTipCardParagraphPresent() {
        return getRightTipCardParagraph().getText().length() > 0;
    }

}
