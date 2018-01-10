package tests.basetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;
import tests.BaseTestPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/9/2018.
 */
public class LogOffTest extends BaseTestPage {
	@Test(description = "Log off test", groups = "p0")
	public void log_off_test() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		loginPage = baseMailPage.logOff();
		Assert.assertTrue(loginPage.isNextBntDisplayed());
		Assert.assertTrue(loginPage.isPasswordInputDisplayed());
		makeScreenshots();
	}
}