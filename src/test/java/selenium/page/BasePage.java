package selenium.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	protected WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected void setInputValue(WebElement webElement, String inputValue) {
		webElement.clear();
		webElement.sendKeys(inputValue);
	}

	protected boolean isVisible(WebElement webElement) {
		try {
			return webElement.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
