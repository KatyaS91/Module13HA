package tests;

import actiontest.BaseTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/9/2018.
 */
public class LoginTest extends BaseTestPage {
	@Test(description = "Check login form", groups = "p0")
	public void login_test() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		BaseMailPage baseMailPage = login.login();
		Assert.assertTrue(baseMailPage.isPageOpened(), "Account page wasn't opened");
		makeScreenshots(driver, "d:\\tmp", "Screen2.png");
	}
}