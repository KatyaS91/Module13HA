package tests;

import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/3/2018.
 */
public class ScrollTest extends BaseTestPage{

	@Test(description = "Check scroll", groups = "p0")
	public void scroll_test() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		scrollDown(baseMailPage.letters);
		Thread.sleep(3000);
	}
}
