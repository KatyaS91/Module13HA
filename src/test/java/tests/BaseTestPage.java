package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sun.security.krb5.internal.crypto.Des;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseTestPage {

	WebDriver driver;

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");

/*		FirefoxProfile firefoxProfile = new FirefoxProfile();
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities.setPlatform(Platform.WINDOWS);
		desiredCapabilities.setVersion("57");
		desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
		String hubHost = "localhost";
		try {
			driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion("63");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}

	void scrollDown(WebElement targetElement) {
		new Actions(driver).moveToElement(targetElement).build().perform();
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("scroll(0, 400);");
		System.out.println("Scroll down");
	}
	void doubleClick (WebElement element) {
		new Actions(driver).doubleClick(element).build().perform();
	}

	void makeScreenshots() {
		try {
			Date currDate = new Date();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFileToDirectory(screenshot, new File("d:\\tmp\\screenshot" + currDate.toString().trim() +".png"));
		} catch (Exception ex) {}
	}
}