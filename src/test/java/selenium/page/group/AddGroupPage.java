package selenium.page.group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.page.BasePage;

/**
 * Страница добавления группы.
 */
public class AddGroupPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//button[@name='_save']")
	private WebElement saveGroupButton;
	@FindBy(how = How.XPATH, using = "//input[@id='id_name']")
	private WebElement groupNameInput;

	public AddGroupPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Создать новую группу.
	 */
	public GroupListPage addGroup(String groupName) {
		setName(groupName);
		return saveGroup();
	}

	/**
	 * Заполнить название группы.
	 */
	public void setName(String groupName) {
		groupNameInput.sendKeys(groupName);
	}

	/**
	 * Нажимает кнопку "сохранить".
	 */
	public GroupListPage saveGroup() {
		saveGroupButton.click();
		return new GroupListPage(driver);
	}
}
