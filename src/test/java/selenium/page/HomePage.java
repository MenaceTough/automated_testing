package selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница авторизации.
 */
public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = "//input[@id='id_username']")
	private WebElement loginInput;
	@FindBy(how = How.XPATH, using = "//input[@id='id_password']")
	private WebElement passwordInput;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement authButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Ввести логин.
	 */
	public HomePage setLogin(String login) {
		loginInput.sendKeys(login);
		return this;
	}

	/**
	 * Ввести пароль.
	 */
	public HomePage setPassword(String login) {
		passwordInput.sendKeys(login);
		return this;
	}

	/**
	 * Нажать кнопку "войти".
	 */
	public void auth() {
		authButton.click();
	}
}
