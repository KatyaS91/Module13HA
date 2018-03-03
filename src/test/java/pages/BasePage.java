package pages;

import utils.driversingleton.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.elementdecorator.CustomWebDriver;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public class BasePage {

	public CustomWebDriver driver;

	public BasePage(CustomWebDriver driver) {
		this.driver =  WebDriverSingleton.getWebDriverInstance();
		PageFactory.initElements(driver, this);
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}
}
