package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commanMethods.CommanMethods;

public class OpenNewAccountPage extends BasePage{
	
	public OpenNewAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//open new account link
	@FindBy(linkText = "Open New Account")
	private static WebElement linkOpenNewAcc;
	
	//account type drop down
	@FindBy(id = "type")
	private static WebElement drpdwnAccType;
	
	//existing account drop down
	@FindBy(id = "fromAccountId")
	private static WebElement drpdwnExistingAcc;
	
	//open new account button
	@FindBy(tagName = "input")
	private static WebElement buttonOpenNewAcc;
	
	//click on open new account link
	public static void setLinkOpenNewAcc() {
		linkOpenNewAcc.click();
	}
	
	//select account type
	public static void setDrpdwnAccType(String value) {
			CommanMethods.select(drpdwnAccType, value);
	}
	
	//select existing account no
	public static void setDrpdwnExistingAcc(String value) {
	
		CommanMethods.select(drpdwnExistingAcc, value);
	}
	
	//click on open new account button
	public static void clickOnButtonOpenNewAcc() {
		buttonOpenNewAcc.click();
	}
}
