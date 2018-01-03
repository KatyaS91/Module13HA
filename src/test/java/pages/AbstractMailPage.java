package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public abstract class AbstractMailPage {

	public WebDriver driver;

	public AbstractMailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}



}