package pages;

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
	public WebElement passwordInput;
	@FindBy(css = "#identifierId")
	public WebElement loginInput;

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
		return nextBtn.isDisplayed();
	}

	public boolean isPasswordInputDisplayed() {
		return passwordInput.isDisplayed();
	}
}