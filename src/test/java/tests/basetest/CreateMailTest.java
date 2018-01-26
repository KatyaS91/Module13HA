package tests.basetest;

import bo.MailBO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.DraftPage;
import pages.LoginPage;
import pages.MailCreationPage;
import tests.BaseTestPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/9/2018.
 */
public class CreateMailTest extends BaseTestPage {

	@Test(description = "Create email", groups = "p0")
	public void create_mail() {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		MailCreationPage mailCreationPage = baseMailPage.openCreateMailPage();
		MailBO mailBO = new MailBO();
		mailCreationPage.createMail(mailBO);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.isExpectedDraftSubjectPresent(mailBO.getSubject()), "The draft with subject isn't displayed");
		Assert.assertTrue(draftPage.isExpectedDraftBodyDisplayed(mailBO.getDescription()), "The draft with body isn't displayed");
		makeScreenshots();
	}
}