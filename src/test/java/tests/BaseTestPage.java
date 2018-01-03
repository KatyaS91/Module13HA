package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static data.TestData.URL;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseTestPage {

	WebDriver driver;

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(URL.getValue());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}

	//scroll action
	void scrollDown(WebElement targetElement) {
		new Actions(driver).moveToElement(targetElement).build().perform();
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("scroll(0, 400);");
		System.out.println("Scroll down");
	}
	//double click action
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