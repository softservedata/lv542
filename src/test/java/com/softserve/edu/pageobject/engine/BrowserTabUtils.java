package com.softserve.edu.pageobject.engine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public interface BrowserTabUtils {

    default String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    default String getCurrentTabHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    default void openNewTab(WebDriver driver, int countTab) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        //
        // Robot rob = new Robot();
        // rob.keyPress(KeyEvent.VK_CONTROL);
        // rob.keyPress(KeyEvent.VK_T);
        //
        WaitWrapper.newTabAvailableWait(driver, countTab);
    }
    
    default void switchToTab(WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }
    
    default String switchToAnotherTab(WebDriver driver, List<String> windowHandles) {
        boolean isFound = false;
        for (String current : driver.getWindowHandles()) {
            isFound = false;
            for (String tabHandle : windowHandles) {
                if (current.equals(tabHandle)) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                driver.switchTo().window(current);
                break;
            }
        }
        return getCurrentTabHandle(driver);
    }

    default void closeAllTab(WebDriver driver, String exceptWindowHandle) {
        List<String> windowHandles = new ArrayList<>();
        for (String current : driver.getWindowHandles()) {
            if (!current.equals(exceptWindowHandle)) {
                windowHandles.add(current);
            }
        }
        for (String current : windowHandles) {
            driver.switchTo().window(current);
            driver.close();
        }
    }
    
   /*-
    default void getTitle(WebDriver driver, List<String> titlesToClose) {
      List<String> windowHandles = new ArrayList<>();
      for (String current : driver.getWindowHandles())
      { System.out.println("Window Handle: " + current);
      windowHandles.add(current);
      //
      }
      // if (!current.equals(currentTab)) {
      //
      driver.switchTo().window(current);
      //
      break;
      //
      } } }
    */

}
