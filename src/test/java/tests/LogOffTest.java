package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
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