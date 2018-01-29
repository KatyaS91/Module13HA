package tests;

import utils.driversingleton.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.elementdecorator.CustomWebDriver;

import java.io.File;

/**
 * Created by Katsiaryna_Skarzhyns on 1/4/2018.
 */
public class BaseTestPage {

	public CustomWebDriver driver;

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void setUp() {
		driver = WebDriverSingleton.getWebDriverInstance();
	}

	@AfterClass public void cleanUp() {
		driver.quit();
	}

	protected void scrollDown(WebElement targetElement) {
		new Actions(driver).moveToElement(targetElement).build().perform();
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("scroll(0, 400);");
		System.out.println("Scroll down");
	}

	protected void doubleClick(WebElement element) {
		new Actions(driver).moveToElement(element).doubleClick(element).build().perform();
	}

	protected void makeScreenshots() {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFileToDirectory(screenshot, new File("d:\\tmp\\screenshot"));
		} catch (Exception ex) {
			ex.fillInStackTrace();
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

	protected void highlightElement(WebDriver driver, WebElement element) {
		String background = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.background = '" + "yellow" + "'", element);
		js.executeScript("arguments[0].style.background = '" + background + "'", element);
	}
}