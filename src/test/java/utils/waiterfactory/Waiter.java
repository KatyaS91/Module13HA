package utils.waiterfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public abstract class Waiter {

	public abstract void waitForPageIsLoaded(WebDriver driver, final By by);
}