package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.DraftPage;
import pages.LoginPage;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class CreateMailTest extends BaseTestPage {

	private static final String ADDRESS = "test@gmail.com";
	private static final String SUBJECT = "The test subject";
	private static final String BODY = "Bla bla";

	@Test(description = "Create email", groups = "p1")
	public void create_mail() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		baseMailPage.createMail(ADDRESS, SUBJECT, BODY);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.isExpectedDraftSubjectPresent(SUBJECT), "The draft with subject isn't displayed");
		Assert.assertTrue(draftPage.isExpectedDraftBodyDisplayed(BODY), "The draft with body isn't displayed");
	}
}