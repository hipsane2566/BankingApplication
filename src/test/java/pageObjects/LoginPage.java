package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// input userName
	@FindBy(name = "username")
	WebElement inputUsername;

	// input password
	@FindBy(name = "password")
	WebElement inputPassword;

	// button login
	@FindBy(css = "input.button")
	WebElement btnLogin;

	// enter userName
	public void setUsername(String username) {
		inputUsername.sendKeys(username);
	}

	// enter password
	public void setPassword(String password) {
		inputPassword.sendKeys(password);
	}

	// click on loginButton
	public void clickOnLoginBtn() {
		btnLogin.click();
	}

}
