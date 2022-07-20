package selenium.page.group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.page.BasePage;

public class DeleteGroupPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @class='btn btn-danger']")
	private WebElement deleteGroupButton;

	public DeleteGroupPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Нажать кнопку подтверждения удаления.
	 */
	public GroupListPage confirmDelete() {
		deleteGroupButton.click();
		return new GroupListPage(driver);
	}
}
