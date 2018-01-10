package tests.basetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTestPage;

/**
 * Created by Katsiaryna_Skarzhyns on 1/10/2018.
 */
public class SendMailTest extends BaseTestPage {
	private static final String ADDRESS = "KatyaS91@mail.ru";
	private static final String SUBJECT = "The test subject";
	private static final String BODY = "Bla bla";

	@Test(description = "Check sending", groups = "p0")
	public void sent_mail() {
		LoginPage loginPage = new LoginPage(driver);
		BaseMailPage baseMailPage = loginPage.login();
		MailCreationPage mailCreationPage = baseMailPage.openCreateMailPage();
		mailCreationPage.createMail(ADDRESS, SUBJECT, BODY);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.sendDraft(0), "The mail doesn't disappear from drafts");
		SentPage sentPage = draftPage.openSentMails();
		Assert.assertTrue(sentPage.isExpectedMailPresent(BODY, SUBJECT, ADDRESS), "Expected mail doesn't present in the folder");
		makeScreenshots();
	}
}