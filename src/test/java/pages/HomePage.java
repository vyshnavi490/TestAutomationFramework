package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "amount")
	public WebElement amount;

	@FindBy(xpath = "//*[@class='text-danger'  or @class = 'text-success']")
	public List<WebElement> list;

	public void clickAmount() {

		amount.click();
	}

	public ArrayList<String> getListValues() {

		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i).getText().replaceAll("[^\\d.-]", ""));
		}
		return result;
	}
}
