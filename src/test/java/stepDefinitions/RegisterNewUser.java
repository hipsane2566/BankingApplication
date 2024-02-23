package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.RegistrationPage;

public class RegisterNewUser {
	
	static RegistrationPage register ;
	@Given("open app url")
	public void open_app_url() throws IOException {
	    LoginSteps.open_app_url();
	}
	
	@Given("navigate to registration page")
	public void navigate_to_registration_page() {
		register=  new RegistrationPage(BaseClass.getDriver());
	    register.clickOnRegisterLink();
	}

	@When("user enters the details into required fields")
	public static void user_enters_the_details_into_required_fields(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		register = new RegistrationPage(BaseClass.getDriver());
		register.clickOnRegisterLink();
		register.enterFirstname(datamap.get("firstname"));
		register.enterLastname(datamap.get("lastname"));
		register.setAddress();
		register.setCity();
		register.setState();
		register.zipCode();
		register.phoneNumber();
		register.sSN();
		String  lastgenerated_username = RegistrationPage.setUsername("firstname", true);
		String password = RegistrationPage.setPassword();
		register.enterUsername(lastgenerated_username, false);
		register.enterPassword(password);
		register.enterConfirmPassword(password);
		
	}

	@When("click on register button")
	public static void click_on_register_button() throws InterruptedException {
		register.clickOnRegisterButton();
		Thread.sleep(10000);
	}

	@Then("account register successfully message should be displayed")
	public void account_register_successfully_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user able to login with the register account details")
	public void user_able_to_login_with_the_register_account_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	}


