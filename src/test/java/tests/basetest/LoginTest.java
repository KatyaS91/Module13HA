package tests.basetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;
import tests.BaseTestPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/9/2018.
 */
public class LoginTest extends BaseTestPage {
	@Test(description = "Check login form", groups = "p0")
	public void login_test() {
		LoginPage login = new LoginPage(driver);
		BaseMailPage baseMailPage = login.login();
		Assert.assertTrue(baseMailPage.isPageOpened(), "Account page wasn't opened");
		makeScreenshots();
	}
}