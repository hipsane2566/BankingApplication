package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AccountCreation {

	@Given("login to the application {string}")
	public void login_to_the_application(String rows) throws IOException {
		LoginSteps.open_app_url();
		LoginSteps.user_enter_username_and_password_with_excel_row(rows);
		LoginSteps.user_click_on_login_button();
	}

	@When("click on open new account link")
	public void click_on_open_new_account_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("select the account type as {string}")
	public void select_the_account_type_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("select the account from which the amount to be transfer {string}")
	public void select_the_account_from_which_the_amount_to_be_transfer(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on open new account button")
	public void click_on_open_new_account_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("account opened message should be displayed")
	public void account_opened_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("account number should be generated")
	public void account_number_should_be_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
