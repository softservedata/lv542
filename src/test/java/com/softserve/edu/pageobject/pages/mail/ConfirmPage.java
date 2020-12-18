package com.softserve.edu.pageobject.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class ConfirmPage {

    protected WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Object

    // Functional

    // Business Logic

    public MyHabitsPage chooseLanguage(Languages languageName) {
        // TODO create const
        return new MyHabitsPage(driver);
    }
}
