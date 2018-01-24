package tests.basetest;

import bo.Mail;
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
		Mail mail = new Mail();
		mailCreationPage.createMail(mail);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.isExpectedDraftSubjectPresent(mail.getSubject()), "The draft with subject isn't displayed");
		Assert.assertTrue(draftPage.isExpectedDraftBodyDisplayed(mail.getDescription()), "The draft with body isn't displayed");
		makeScreenshots();
	}
}