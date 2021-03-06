package utils.driversingleton;

import utils.data.TestData;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import utils.elementdecorator.CustomWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class WebDriverSingleton {

	private static CustomWebDriver driver;
	private static DesiredCapabilities capabilities;
	private static ITestContext context;
	//private static String browser = context.getCurrentXmlTest().getParameter("browser");
	private static String browser = "chrome";

	private WebDriverSingleton() {
	}

	public static CustomWebDriver getWebDriverInstance() {
		if(driver == null) {
			if (browser.equalsIgnoreCase("firefox")) {
				capabilities = DesiredCapabilities.firefox();
				capabilities.setPlatform(Platform.WINDOWS);
				capabilities.setVersion("57");
			}
			if (browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
				capabilities = DesiredCapabilities.chrome();
				capabilities.setPlatform(Platform.WINDOWS);
				capabilities.setVersion("63.0");
			}
			try {
				//driver = new CustomWebDriver(new ChromeDriver(capabilities));
				driver = new CustomWebDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
				driver.manage().window().maximize();
				driver.get(TestData.URL.getValue());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
		}
		return driver;
	}

	public static void cleanUp() {
		driver.quit();
		driver = null;
	}
}