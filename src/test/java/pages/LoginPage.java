package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.TestData.LOGIN;
import static data.TestData.PASSWORD;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class LoginPage extends BaseMailPage {

	@FindBy(css = "div [id*= 'Next']")
	public WebElement nextBtn;
	@FindBy(css = "input[type = 'password']")
	private WebElement passwordInput;
	@FindBy(css = "#identifierId")
	public WebElement loginInput;
	@FindBy(xpath = "//div[contains(text(), 'More options')]")
	public WebElement moreOptionsBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public BaseMailPage login() {
		loginInput.sendKeys(LOGIN.getValue());
		nextBtn.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(PASSWORD.getValue());
		nextBtn.click();
		return new BaseMailPage(driver);
	}

	public boolean isNextBntDisplayed() {
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [id*= 'Next']"))).isDisplayed();
	}

	public boolean isPasswordInputDisplayed() {
		return passwordInput.isDisplayed();
	}

	public boolean isMenuDisplayed() {
		return driver.findElement(By.xpath("//div[@role='menu']")).isDisplayed();
	}

	public boolean isCursorPointer() {
		return driver.findElement(By.tagName("body")).getCssValue("cursor").equals("auto");
	}

	public boolean isInputEmpty(WebElement input) {
		return input.getText().length()==0;
	}
}