package tests;

import data.TestData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsiaryna_Skarzhyns on 1/4/2018.
 */
public class BaseTestPage {
	public WebDriver driver;
	private DesiredCapabilities capabilities;

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void startBrowser(ITestContext context) {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		String browser = context.getCurrentXmlTest().getParameter("browser");

		if (browser.equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setVersion("57");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			capabilities = DesiredCapabilities.chrome();
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setVersion("63.0");
		}

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			driver.manage().window().maximize();
			driver.get(TestData.URL.getValue());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
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