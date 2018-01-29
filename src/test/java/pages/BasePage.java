package pages;

import org.openqa.selenium.WebDriver;
import utils.driversingleton.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver =  WebDriverSingleton.getWebDriverInstance();
		WaitUtils.waitForPageToLoad(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}
}
