package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.elementdecorator.CustomWebDriver;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class SentPage extends BaseMailPage {

	private final static String EXPECTED_LETTER_XPATH = "//span[contains(text(), '%s')]//ancestor::td//..//span[contains(text(), '%s')]//ancestor::td//..//div//span[contains(@email, '%s')]";

	private static final Logger LOG = Logger.getLogger(SentPage.class);

	SentPage(CustomWebDriver driver) {
		super(driver);
	}

	public boolean isExpectedMailPresent(String body, String subject, String address) {
		try {
			return driver.findElements(By.xpath(String.format(EXPECTED_LETTER_XPATH, body, subject, address))).size() > 0;
		} catch (NoSuchElementException ex) {
			LOG.info("Expected mail isn't displayed");
			return false;
		}
	}
}