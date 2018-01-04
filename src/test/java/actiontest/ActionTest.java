package actiontest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/4/2018.
 */
public class ActionTest extends BaseTestPage {

	@Test(description = "Action checking", groups = "p0")
	public void create_mail() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		highlightElement(driver, loginPage.loginInput);
		doubleClick(loginPage.moreOptionsBtn);
		Assert.assertTrue(loginPage.isMenuDisplayed(), "Menu popup isn't displayed");
		hover(loginPage.nextBtn);
		Assert.assertTrue(loginPage.isCursorPointer(), "Cursor isn't change to pointer");
		makeScreenshots();
		loginPage.loginInput.sendKeys("test");
		clearInputViaHotKeys(loginPage.loginInput);
		Assert.assertTrue(loginPage.isInputEmpty(loginPage.loginInput), "Login input isn't empty");
	}
}