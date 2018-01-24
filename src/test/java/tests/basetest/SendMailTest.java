package tests.basetest;

import bo.Mail;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTestPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/10/2018.
 */
public class SendMailTest extends BaseTestPage {

	@Test(description = "Check sending", groups = "p0")
	public void sent_mail() {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		MailCreationPage mailCreationPage = baseMailPage.openCreateMailPage();
		Mail mail = new Mail();
		mailCreationPage.createMail(mail);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.sendDraft(0), "The mail doesn't disappear from drafts");
		SentPage sentPage = draftPage.openSentMails();
		Assert.assertTrue(sentPage.isExpectedMailPresent(mail.getDescription(), mail.getSubject(), mail.getAddress()), "Expected mail doesn't present in the folder");
		makeScreenshots();
	}
}