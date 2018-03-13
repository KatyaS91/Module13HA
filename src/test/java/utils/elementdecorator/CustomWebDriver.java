package utils.elementdecorator;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Set;

public class CustomWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot {

	protected RemoteWebDriver rwd;

	private static final Logger LOG = Logger.getLogger(CustomWebDriver.class);

	public CustomWebDriver(RemoteWebDriver driver) {
		rwd = driver;
	}

	public void get(String url) {
		rwd.get(url);
	}

	public String getCurrentUrl() {
		return rwd.getCurrentUrl();
	}

	public String getTitle() {
		return rwd.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return rwd.findElements(by);
	}

	public WebElement findElement(By by) {
		WebElement element = rwd.findElement(by);
		JavascriptExecutor js = ((JavascriptExecutor) rwd);
		js.executeScript("arguments[0].style.background = '" + "yellow" + "'", element);
		LOG.info("Element located by " + by.toString() + " was find");
		String background = element.getCssValue("backgroundColor");
		js.executeScript("arguments[0].style.background = '" + background + "'", element);
		return element;
	}

	public String getPageSource() {
		return rwd.getPageSource();
	}

	public void close() {
		rwd.close();
	}

	public void quit() {
		rwd.close();
	}

	public Set<String> getWindowHandles() {
		return rwd.getWindowHandles();
	}

	public String getWindowHandle() {
		return rwd.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return rwd.switchTo();
	}

	public Navigation navigate() {
		return rwd.navigate();
	}

	public Options manage() {
		return rwd.manage();
	}

	public Object executeScript(String script, Object... args) {
		return rwd.executeScript(script, args);
	}

	public Object executeAsyncScript(String script, Object... args) {
		return rwd.executeAsyncScript(script, args);
	}

	public WebElement findElementById(String using) {
		return rwd.findElementById(using);
	}

	public List<WebElement> findElementsById(String using) {
		return rwd.findElementsById(using);
	}

	public WebElement findElementByClassName(String using) {
		return rwd.findElementByClassName(using);
	}

	public List<WebElement> findElementsByClassName(String using) {
		return rwd.findElementsByClassName(using);
	}

	public WebElement findElementByLinkText(String using) {
		return rwd.findElementByLinkText(using);
	}

	public List<WebElement> findElementsByLinkText(String using) {
		return rwd.findElementsByLinkText(using);
	}

	public WebElement findElementByPartialLinkText(String using) {
		return rwd.findElementByPartialLinkText(using);
	}

	public List<WebElement> findElementsByPartialLinkText(String using) {
		return rwd.findElementsByPartialLinkText(using);
	}

	public WebElement findElementByName(String using) {
		return rwd.findElementByName(using);
	}

	public List<WebElement> findElementsByName(String using) {
		return findElementsByName(using);
	}

	public WebElement findElementByCssSelector(String using) {
		return rwd.findElementByCssSelector(using);
	}

	public List<WebElement> findElementsByCssSelector(String using) {
		return rwd.findElementsByCssSelector(using);
	}

	public WebElement findElementByTagName(String using) {
		return rwd.findElementByTagName(using);
	}

	public List<WebElement> findElementsByTagName(String using) {
		return rwd.findElementsByTagName(using);
	}

	public WebElement findElementByXPath(String using) {
		return rwd.findElementByXPath(using);
	}

	public List<WebElement> findElementsByXPath(String using) {
		return rwd.findElementsByXPath(using);
	}

	public Keyboard getKeyboard() {
		return rwd.getKeyboard();
	}

	public Mouse getMouse() {
		return rwd.getMouse();
	}

	public Capabilities getCapabilities() {
		return rwd.getCapabilities();
	}

	public <X> X getScreenshotAs(OutputType<X> target)
			throws WebDriverException {
		return rwd.getScreenshotAs(target);
	}
}