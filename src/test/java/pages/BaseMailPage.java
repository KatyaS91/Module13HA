package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.elementdecorator.CustomWebDriver;

import static utils.data.TestData.LOGIN;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseMailPage extends BasePage {
	private String accountLogoXpath = "//*[contains(@title, '%s')]";

	@FindBy(xpath = "//a[contains(text(), 'Выйти')]")
	private WebElement exitBtn;
	@FindBy(xpath = "//div[contains(@role, 'button') and contains(text(), 'НАПИСАТЬ')]")
	private WebElement writeBtn;
	@FindBy(xpath = "//*[contains(@aria-label, 'Черновики')]")
	private WebElement draftsBtn;
	@FindBy(xpath = "//*[contains(@title, 'Отправленные')]")
	private WebElement sentBtn;
	@FindBy(xpath = "//div[@role='main']")
	public WebElement letters;

	private static final Logger LOG = Logger.getLogger(BaseMailPage.class);

	BaseMailPage(CustomWebDriver driver) {
		super(driver);
	}

	public MailCreationPage openCreateMailPage() {
		writeBtn.click();
		LOG.info("Click on write button");
		return new MailCreationPage(driver);
	}

	public boolean isPageOpened() {
		try {
			return driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).isDisplayed();
		} catch (NoSuchElementException ex) {
			LOG.error("The page isn't opened", ex);
			return false;
		}
	}

	public void clickWriteBtn() {
		writeBtn.click();
	}

	public DraftPage openDrafts() {
		draftsBtn.click();
		LOG.info("Click on drafts button");
		return new DraftPage(driver);
	}

	public SentPage openSentMails() {
		sentBtn.click();
		LOG.info("Click on sent button");
		return new SentPage(driver);
	}

	public LoginPage logOff() {
		driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).click();
		exitBtn.click();
		LOG.info("Click on exit button");
		return new LoginPage(driver);
	}
}