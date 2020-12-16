package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Owner(value = "OWNER First name")
@Epic("EPIC AllureTest")
@Feature("FEATURE SearchAllureTes")
public class SearchAllureTest {
	private static WebDriver driver;
	private User currentUser;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
		Thread.sleep(1000); // For Presentation Only
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver.get("https://ita-social-projects.github.io/GreenCityClient/");
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (!result.isSuccess()) {
			saveImageAttach("PICTURE Test name = " + result.getName());
			saveHtmlAttach("HTML User is "+ currentUser);
		}
		// logout, get(urlLogout), delete cookie, delete cache
	}


	@Attachment(value = "{0}", type = "image/png")
	public byte[] saveImageAttach(String attachName) {
		byte[] result = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			result = Files.readAllBytes(scrFile.toPath());
			FileUtils.copyFile(scrFile, new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.png"));
		} catch (IOException e) {
			// TODO Create Custom Exception 
			e.printStackTrace();
		}
		return result;
	}

	@Attachment(value = "{0}", type = "text/plain")
	public byte[] saveHtmlAttach(String attachName) {
		return driver.getPageSource().getBytes();
	}

	
	@Attachment(value = "{0}", type = "text/plain")
	public byte[] saveTextAttach(String attachName, String fileName) {
		String path = this.getClass().getResource("/").getPath();
		path = path.replace("target/test-classes/", fileName);
		path = path.substring(1);
		byte[] result = null;
		try {
			result = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			// TODO Create Custom Exception 
			e.printStackTrace();
		}
		return result;
	}

	protected void takeScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.png"));
		String htmlText = driver.getPageSource();
		//FileUtils.writeStringToFile(new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.html"), htmlText);
		Path path = Paths.get(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.html");
		Files.write(path, htmlText.getBytes(), StandardOpenOption.CREATE);
	}
	
	
	@Step("STEP Start")
    private void start() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // For Presentation Only
    }
	
	@Step("STEP Load Application")
	protected WelcomePage loadApplication() {
        return new WelcomePage(driver);
    }
	
	@DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }

	@Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
	@Severity(SeverityLevel.BLOCKER)
	@Story("STORY SearchAllureTest")
	@Issue("SSITAGT-1")
	@Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
	@TmsLink(value = "TL-678")
    @Test(dataProvider = "users")
	public void checkLogin(User user) {
	    start();
	    currentUser = user;
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateLogin()
                .successfulLogin(user);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                user.getName());
        WelcomePage welcomePage = myHabitsPage.gotoLogout();
        Assert.assertTrue(welcomePage.isSignInAvailable());
        //throw new RuntimeException("ha-ha-ha");
    }
	
}
