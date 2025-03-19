package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import base.BaseTest;
import pageObject.LoginPage;
import utils.ConfigReader;



public class LoginTest extends BaseTest {
	
	
	@Test
    public void testValidLogin() throws InterruptedException {
		
		
			try {
			logger = extent.startTest("Valid Login Test", "This Test is performed only to show how a passed test works");
			LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(ConfigReader.getProperty("Username"), ConfigReader.getProperty("Password"));
	        logger.log(LogStatus.PASS, "LOGIN SUCCESSFUL");
	        Reporter.log("LOGIN SUCCESSFUL", true);
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.=' Vehicles ']")));     
	        logger.log(LogStatus.PASS, "Home page open successfully");
	        Reporter.log("Home page open successfully", true);
			Thread.sleep(2000);
			
			String title = driver.getTitle();
			Reporter.log(title);
			logger.log(LogStatus.PASS, "Navigated to business");
			logger.log(LogStatus.PASS, "Page title is: " + title);
	        
	        if (title.equalsIgnoreCase("Business1")) {
				logger.log(LogStatus.PASS, "Title matched successsfully");
				Reporter.log("Title matched successsfully", true);
			}// This will fail
	        else {
				logger.log(LogStatus.FAIL, "Title not matched");
				Reporter.log("Title not matched", true);
				Assert.fail("Title not matched");
			}
			} catch (Exception e) {
				Assert.fail("test failed");
			}
        
	}
	
}
