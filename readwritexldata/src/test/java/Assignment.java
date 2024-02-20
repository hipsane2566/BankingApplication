
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

    public static void clearTxtBox(WebDriver driver, WebElement elem, String text) {
        elem.clear();
        elem.sendKeys(text);
    }

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        String filename = System.getProperty("user.dir") + "\\readwritexldata\\TestData\\Citbank.xlsx";
        String sheet = "Sheet1";

        // read the excel data
        int rowno = ExcelUtility.getRowNo(filename, sheet);
        for (int i = 1; i <= rowno; i++) {
            String amount = ExcelUtility.getCellData(filename, sheet, i, 0);
            String months = ExcelUtility.getCellData(filename, sheet, i, 1);
            String interest = ExcelUtility.getCellData(filename, sheet, i, 2);
            String compound = ExcelUtility.getCellData(filename, sheet, i, 3);
            String expValue = ExcelUtility.getCellData(filename, sheet, i, 4);

            // write data to application
            WebElement amountTxtBox = driver.findElement(By.id("mat-input-0"));
            clearTxtBox(driver, amountTxtBox, amount);
            WebElement monthTxtBox = driver.findElement(By.id("mat-input-1"));
            clearTxtBox(driver, monthTxtBox, months);
            WebElement interestTextBox = driver.findElement(By.id("mat-input-2"));
            clearTxtBox(driver, interestTextBox, interest);



            Actions action = new Actions(driver);
            action.sendKeys(Keys.TAB).perform();
            action.keyDown(Keys.ARROW_UP).perform();
            int n = 1;
            while(n>0){
                
                String drpValue = driver.findElement(By.cssSelector("span[class='ng-tns-c109-4 ng-star-inserted']")).getText();
                if(drpValue.equals(compound)){
                    n = -1;
                }else{
                    action.keyDown(Keys.ARROW_DOWN).perform();
                }
            }

            driver.findElement(By.id("CIT-chart-submit")).click();

            String actualValue = driver.findElement(By.id("displayTotalValue")).getText();
            driver.navigate().refresh();
            if (expValue.equals(actualValue)) {
                ExcelUtility.setCellData(filename, sheet, i, 5, "Passed");
                System.out.println("Test case " + i + " is passed." + actualValue);
            } else {
                ExcelUtility.setCellData(filename, sheet, i, 5, "Failed");
                System.out.println("Test case " + i + " is failed." + actualValue);
            }

        }
        driver.close();

    }
}
