package com.softserve.edu.pageobject.engine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public interface BrowserTabUtils {
    
    default String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    default void getTitle(WebDriver driver, List<String> titlesToClose) {
        List<String> windowHandles = new ArrayList<>();
        for (String current : driver.getWindowHandles()) {
            System.out.println("Window Handle: " + current);
            windowHandles.add(current);
//        }
//            if (!current.equals(currentTab)) {
//                driver.switchTo().window(current);
//                break;
//            }
        }
    }
    
}
