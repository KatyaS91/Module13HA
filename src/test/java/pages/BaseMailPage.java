package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.TestData.LOGIN;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseMailPage extends MailAbstractPage {
	private String accountLogoXpath = "//*[contains(@title, '%s')]";
	private String exitBtnXpath = "//a[contains(text(), 'Выйти')]";
	private String writeBtnXpath = "//div[contains(@role, 'button') and contains(text(), 'НАПИСАТЬ')]";
	private String subjectXpath = "//*[@name = 'subjectbox']";
	private String bodyXpath = "//div[@role = 'textbox']";
	private String addressXpath = "//textarea[@name = 'to']";
	private String sendXpath = "//div[contains(text(), 'Отправить')]";
	private String draftBtnXpath = "//*[contains(@aria-label, 'Черновики')]";
	private String sentBtnXpath = "//*[contains(@title, 'Отправленные')]";
	private String letterIsCreatedIndicator = "//span[text() = 'Сохранено']";

	@FindBy(xpath = "//div[@role='main']")
	public WebElement letters;

	BaseMailPage(WebDriver driver) {
		super(driver);
	}

	public void createMail(String address, String subject, String body) throws InterruptedException {
		clickWriteBtn();
		driver.findElement(By.xpath(addressXpath)).sendKeys(address);
		driver.findElement(By.xpath(subjectXpath)).sendKeys(subject);
		driver.findElement(By.xpath(bodyXpath)).sendKeys(body);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(letterIsCreatedIndicator)));
	}

	public boolean isPageOpened() {
		try {
			return driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public void clickWriteBtn() {
		driver.findElement(By.xpath(writeBtnXpath)).click();
	}

	public DraftPage openDrafts() {
		driver.findElement(By.xpath(draftBtnXpath)).click();
		return new DraftPage(driver);
	}

	public SentPage openSentMails() throws InterruptedException {
		driver.findElement(By.xpath(sentBtnXpath)).click();
		return new SentPage(driver);
	}

	public void send() {
		driver.findElement(By.xpath(sendXpath)).click();
	}

	public LoginPage logOff() {
		driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).click();
		driver.findElement(By.xpath(exitBtnXpath)).click();
		return new LoginPage(driver);
	}
}