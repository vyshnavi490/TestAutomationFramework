package tests;

import java.util.ArrayList;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.Settings;
import pages.HomePage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class AssignmentTest extends BaseClass {

	@Test(description = "Validating the login is working fine by verify home page url after logging in")
	public void tc1() {

		LoginPage lp = new LoginPage(driver);
		lp.performLogin(Settings.username, Settings.password);
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str.contains("/home.html"), true);
	}


	@Test(description = "Validating the username warning message - Entering only password and clicking on login")
	public void tc2() {

		LoginPage lp = new LoginPage(driver);
		lp.enterPassword(Settings.password);
		lp.clickLogin();
		String str = lp.getUsernameText();
		Assert.assertEquals(!str.isEmpty(), true);
	}


	@Test(description = "Validating the password warning message - Entering only username and clicking on login")
	public void tc3() {

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(Settings.username);
		lp.clickLogin();
		String str = lp.getPasswordText();
		Assert.assertEquals(!str.isEmpty(), true);
	}


	@Test(description = "Validating username and password warning message - Clicking on login directly")
	public void tc4() {

		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		String str = lp.getBothText();
		Assert.assertEquals(!str.isEmpty(), true);
	}


	@Test(description = "Validating the login button is enabled by default or not (By default the provided url in the assignment has login button enabled)")
	public void tc5() {

		LoginPage lp = new LoginPage(driver);

		Assert.assertTrue(lp.login.isEnabled());
	}


	@Test(description = "Validating login by hitting enter instead of clicking on login")
	public void tc6() {

		LoginPage lp = new LoginPage(driver);
		lp.performLoginUsingEnter(Settings.username, Settings.password);
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str.contains("/home.html"), true);
	}

	@Test(description = "Validating remember me button is selectable or not by firstly selecting it and validating that it is selected")
	public void tc7() {

		LoginPage lp = new LoginPage(driver);
		lp.clickRememberMe();
		Assert.assertTrue(lp.rememberMe.isSelected());
	}


	@Test(description = "Validating the password is getting masked or not on entering the password value in password field")
	public void tc8() {

		LoginPage lp = new LoginPage(driver);
		lp.enterPassword(Settings.password);
		lp.clickLogin();
		String str = lp.getPasswordValue();
		System.out.println("Password value is "+str);
		Assert.assertFalse(str.contains(Settings.password));
	}


	@Test(description = "Validating the login button colour is blue in color")
	public void tc9() {

		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.getLoginButtonColor(),"rgba(4, 123, 248, 1)");
	}


	@Test(priority = 2, description = "Validating the values are in sorting order or not by clicking on amount table in Home page")
	public void tc10() {

		LoginPage lp = new LoginPage(driver);
		lp.performLogin(Settings.username, Settings.password);
		HomePage hp = new HomePage(driver);
		hp.clickAmount();

		ArrayList<String> result = new ArrayList<String>();
		result = hp.getListValues();
		checkSortingOrder(result);

	}

	public void checkSortingOrder(ArrayList<String> result) {
		boolean isSorted = true;
		for (int i = 0; i < result.size() - 1; i++) {
			double value1 = Double.parseDouble(result.get(i)); // string to double format converting
			double value2 = Double.parseDouble(result.get(i + 1));
			if (value1 > value2) {

				isSorted = false;
				break;
			}
		}

		Assert.assertTrue(isSorted && result.size() > 0);
	}

}
