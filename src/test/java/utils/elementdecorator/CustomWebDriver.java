package utils.elementdecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public class CustomWebDriver implements WebDriver {

	protected WebDriver driver;

	public CustomWebDriver (WebDriver driver) {
		this.driver = driver;
	}

	public void get(String s) {
		driver.get(s);
	}

	public String getCurrentUrl() {
		Reporter.log(String.format("Current url is %s", driver.getCurrentUrl()));
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		Reporter.log(String.format("Current title is %s", driver.getTitle()));
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		Reporter.log(String.format("Finding elements: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()));
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()));
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		Reporter.log("Close driver");
		driver.close();
	}

	public void quit() {
		Reporter.log("Close driver");
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}
}