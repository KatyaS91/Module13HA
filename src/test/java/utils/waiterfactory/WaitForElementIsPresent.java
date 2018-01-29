package utils.waiterfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.elementdecorator.CustomWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public class WaitForElementIsPresent extends Waiter {

	public void waitForPageIsLoaded(CustomWebDriver driver, final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
}