package tests;

import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;
import pages.MailCreationPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/3/2018.
 */
public class AttachFileTest extends BaseTestPage {

	private static final String FILE_URL = "C:\\Users\\Katsiaryna_Skarzhyns\\Desktop\\ntcn.png";

	@Test(description = "Check file attachment", groups = "p0")
	public void attachFile_test() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		MailCreationPage mailCreationPage = baseMailPage.openCreateMailPage();
		mailCreationPage.attachFile(FILE_URL);
		Thread.sleep(3000);
	}
}
