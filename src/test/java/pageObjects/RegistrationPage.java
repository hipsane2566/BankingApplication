package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commanMethods.CommanMethods;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	//Register link
	@FindBy(linkText = "Register")
	private static WebElement linkRegister ;
	
	//first name textbox
	@FindBy(id = "customer.firstName")
	private static WebElement firstName ;
	
	//last name textbox
	@FindBy(id = "customer.lastName")
	private static WebElement lastName;
	
	//address textbox
	@FindBy(id = "customer.address.street")
	private static WebElement  address;
	
	//city textbox
	@FindBy(id = "customer.address.city")
	private static WebElement city ;
	
	//state textbox
	@FindBy(id = "customer.address.state")
	private static WebElement state;
	
	//zip code textbox
	@FindBy(id = "customer.address.zipCode")
	private static WebElement zipCode;
	
	//phone number textbos
	@FindBy(id = "customer.phoneNumber")
	private static WebElement phoneNumber;
	
	//SSN textbox
	@FindBy(id = "customer.ssn")
	private static WebElement ssn;
	
	//username textbox
	@FindBy(id = "customer.username")
	private static WebElement username;
	
	//password textbox
	@FindBy(id = "customer.password")
	private static WebElement password;
	
	//confirm password textbox
	@FindBy(id = "repeatedPassword")
	private static WebElement confrimPassword;
	
	//register button
	@FindBy(css = "input[value='Register']")
	private static WebElement registerButton;
	
	//confirm registration message
	@FindBy()
	private static WebElement registerMessage ;
	
	public void clickOnRegisterLink() {
		linkRegister.click();
	}
	
	public void enterFirstname(String fname) {
		String firstname = fname + CommanMethods.random_four_digit_number();
		firstName.sendKeys(firstname);
	}
	
	public void enterLastname(String lname) {
		String lastname = lname + CommanMethods.random_four_digit_number();
		lastName.sendKeys(lastname);
	}
	
	public void setAddress() {
		String address_1 = CommanMethods.randomAlphabet();
		address.sendKeys(address_1);
	}
	
	public void setCity() {
		String city_1 = CommanMethods.randomAlphabet();
		city.sendKeys(city_1);
	}
	
	public void setState() {
		String state_1 = CommanMethods.randomAlphabet();
		state.sendKeys(state_1);
	}
	
	public void zipCode() {
		String code = CommanMethods.random_six_digit_number();
		zipCode.sendKeys(code);
	}
	
	public void phoneNumber() {
		String number = CommanMethods.randomNumeric();
		phoneNumber.sendKeys(number);
	}
	
	public void sSN() {
		String ssncode = CommanMethods.random_four_digit_number();
		ssn.sendKeys(ssncode);
	}
	
	public static String setUsername(String username, boolean lastusername) {
		if(lastusername==true) {
			return username + CommanMethods.random_six_digit_number();
		}else {
			return username + "1234";
		}
	}
	
	public static String setPassword() {
		return CommanMethods.randomAlphaNumeric();
	}
	
	public void enterUsername(String userName, boolean lastusername) {
		if(lastusername==false) {
			username.sendKeys(userName);
		}
		
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String confirmPwd) {
		confrimPassword.sendKeys(confirmPwd);
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
}
