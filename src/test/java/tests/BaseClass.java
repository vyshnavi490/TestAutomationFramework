package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import config.Settings;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void setupDriver() {
		ConfigReader.load();
		if(Settings.browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		} else if (Settings.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(Settings.appURL);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();
	}
}
