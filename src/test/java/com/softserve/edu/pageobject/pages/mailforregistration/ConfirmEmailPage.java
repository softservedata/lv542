package com.softserve.edu.pageobject.pages.mailforregistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class ConfirmEmailPage {

    protected WebDriver driver;

    public ConfirmEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Object

    // Functional

    // Business Logic

    public MyHabitsPage chooseLanguage(Languages languageName) {
        return new MyHabitsPage(driver);
    }
}