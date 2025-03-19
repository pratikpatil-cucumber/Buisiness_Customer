package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;

public class LoginPage {
	
	private WebDriver driver;

    // Web Elements
    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn-submit']") 
    @CacheLookup
    private WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

}
