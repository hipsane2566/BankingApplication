package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountOverviewPage;
import pageObjects.LoginPage;
import utilities.DataReader;

public class LoginSteps {

	WebDriver driver;
	LoginPage loginPage;
	AccountOverviewPage accPage;
	List<HashMap<String, String>> datamap;

	public static List<HashMap<String, String>> getDataMap(String rows) {
		return DataReader.data(System.getProperty("user.dir") + "\\testData\\LoginTestData.xlsx", "Sheet1");
	}

	@Given("Open app url")
	public void open_app_url() throws IOException {
		loginPage = new LoginPage(BaseClass.getDriver());
	}

	@When("User enter username as {string} and password as {string}")
	public void enter_user_name_as_and_password_as(String username, String password) {
		DataReader.data(System.getProperty("user.dir") + "\\testData\\LoginTestData.xlsx", "Sheet1");
		loginPage.setUsername("username");
		loginPage.setPassword("password");
	}

	@When("User enter username and password with excel row {string}")
	public void user_enter_username_and_password_with_excel_row(String rows) {
		datamap = getDataMap(rows);
		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("Username");
		String password = datamap.get(index).get("Password");

		loginPage = new LoginPage(BaseClass.getDriver());
		loginPage.setUsername(email);
		loginPage.setPassword(password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginBtn();
	}

	@Then("User navigate to account overview page {string}")
	public void user_navigate_to_account_overview_page(String rows) throws InterruptedException {
		boolean status = false;
		try {
			datamap = getDataMap(rows);
			int index = Integer.parseInt(rows) - 1;
			String result = datamap.get(index).get("Result");

			accPage = new AccountOverviewPage(BaseClass.getDriver());
			status = accPage.getWelcomeText();
			if (result.equalsIgnoreCase("Valid")) {
				if (status == true) {
					Assert.assertTrue("Test is passed", true);
				} else {
					Assert.assertTrue("Test is Failed", false);
				}
			}
			if (result.equalsIgnoreCase("Invalid")) {
				if (status == true) {
					Assert.assertTrue("Test is failed with invalid data", false);
				} else {
					Assert.assertTrue("Test is passed", true);
				}
			}
		} catch (Exception e) {
			Assert.assertTrue("Test is Failed", status);
		}
	}
}
