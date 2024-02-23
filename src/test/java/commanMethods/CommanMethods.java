package commanMethods;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class CommanMethods {
	
	public static List<WebElement> wait (List<WebElement> list){
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
		return list;
	}
	
	public static WebElement wait (WebElement elem, String value){
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(elem, value));
		return elem;
	}
	
	public static void select(WebElement elem, String value) {
		Select dropdown = new Select(elem);
		dropdown.selectByVisibleText(value);
	}
	
	public static String randomAlphabet() {
		return RandomStringUtils.randomAlphabetic(10);
	}
	
	public static String randomNumeric() {
		 return RandomStringUtils.randomNumeric(10);
	}
	
	public static String randomAlphaNumeric() {
		 String randomAlpaNum =  RandomStringUtils.randomAlphanumeric(10);
		 return randomAlpaNum + "@" + "2023";
	}
	
	public static String random_six_digit_number() {
		return RandomStringUtils.randomNumeric(6);
	}
	
	public static String random_four_digit_number() {
		return RandomStringUtils.randomNumeric(4);
	}
}

