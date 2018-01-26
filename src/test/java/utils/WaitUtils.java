package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katsiaryna_Skarzhyns on 1/24/2018.
 */
public class WaitUtils {

	public static boolean waitForElementToDissapear(WebDriver driver, final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			return wait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static WebElement waitForElementToAppear(WebDriver driver, final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			return wait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static boolean waitForPageToLoad(WebDriver driver) {
		final JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long)js.executeScript("return jQuery.active") == 0);
				}
				catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return js.executeScript("return document.readyState")
						.toString().equals("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
}