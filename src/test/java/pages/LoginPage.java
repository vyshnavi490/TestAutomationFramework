package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);

	}

	@FindBy(id = "username")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "log-in")
	public WebElement login;

	@FindBy(xpath = "//*[text()='Username must be present']")
	public WebElement userNameText;

	@FindBy(xpath = "//*[text()='Password must be present']")
	public WebElement passwordText;

	@FindBy(xpath = "//*[text()='Both Username and Password must be present ']")
	public WebElement bothText;

	@FindBy(className = "form-check-input")
	public WebElement rememberMe;

	public String getUsernameText() {
		return userNameText.getText();
	}
	
	public String getLoginButtonColor() {
		return login.getCssValue("background-color");
	}

	public String getPasswordText() {
		return passwordText.getText();
	}

	public String getBothText() {
		return bothText.getText();
	}

	public void enterUserName(String userNameValue) {

		userName.sendKeys(userNameValue);
	}

	public void enterPassword(String passwordValue) {

		password.sendKeys(passwordValue);
	}

	public void clickLogin() {

		login.click();
	}

	public void performLogin(String userNameValue, String passwordValue) {

		enterUserName(userNameValue);
		enterPassword(passwordValue);
		clickLogin();
	}

	public void performLoginUsingEnter(String userNameValue, String passwordValue) {

		enterUserName(userNameValue);
		enterPassword(passwordValue);
		login.sendKeys(Keys.ENTER);
	}

	public void clickRememberMe() {
		rememberMe.click();
	}

	public String getPasswordValue() {
		return password.getText();
	}

}
