package utils.waiterfactory;

import org.openqa.selenium.By;
import utils.elementdecorator.CustomWebDriver;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public abstract class Waiter {

	public abstract void waitForPageIsLoaded(CustomWebDriver driver, final By by);
}