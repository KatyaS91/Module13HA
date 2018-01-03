package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Katsiaryna_Skarzhyns on 1/3/2018.
 */
public class JsUtils {

	public void highlightElement(WebDriver driver, WebElement element) {
		String background = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.background = '" + "yellow" + "'", element);
		js.executeScript("arguments[0].style.background = '" + background + "'", element);
	}
}