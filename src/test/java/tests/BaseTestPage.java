package tests;

import org.apache.log4j.Logger;
import utils.driversingleton.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.elementdecorator.CustomWebDriver;

import java.io.File;

import static utils.driversingleton.WebDriverSingleton.cleanUp;

/**
 * Created by Katsiaryna_Skarzhyns on 1/4/2018.
 */
public class BaseTestPage {

	public CustomWebDriver driver;
	private static final Logger LOG = Logger.getLogger(BaseTestPage.class);

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void setUp() {
		driver = WebDriverSingleton.getWebDriverInstance();
		LOG.info("Browser started");
	}

	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		cleanUp();
		LOG.info("Browser closed");
	}

	protected void scrollDown(WebElement targetElement) {
		new Actions(driver).moveToElement(targetElement).build().perform();
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("scroll(0, 400);");
		LOG.info("Scroll down");
	}

	protected void doubleClick(WebElement element) {
		new Actions(driver).moveToElement(element).doubleClick(element).build().perform();
	}

	protected void makeScreenshots() {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFileToDirectory(screenshot, new File("d:\\tmp\\screenshot"));
		} catch (Exception ex) {
			LOG.error(ex);
		}
	}

	protected void hover(WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	protected void clearInputViaHotKeys(WebElement input) {
		input.click();
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
		new Actions(driver).sendKeys(Keys.DELETE);
	}
}