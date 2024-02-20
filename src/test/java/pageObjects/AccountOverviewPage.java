package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOverviewPage extends BasePage {
	public AccountOverviewPage(WebDriver driver) {
		super(driver);
	}

	// welcome message text
	@FindBy(xpath = "//b[text()='Welcome']")
	WebElement txtWelcome;

	// get Account page welcome text
	public boolean getWelcomeText() {
		boolean status = false;
		try {
			if (txtWelcome.getText().equalsIgnoreCase("Welcome")) {
				status = true;
			}
			return status;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return status;
		}
	}
}
