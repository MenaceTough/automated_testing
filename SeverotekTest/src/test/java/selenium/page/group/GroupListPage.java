package selenium.page.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.page.BasePage;

/**
 * Страница со списком всех групп.
 */
public class GroupListPage extends BasePage {

	private static final String GROUP_OPTION_XPATH = "//option[@value='%s']";
	private static final String DELETE_ACTION = "delete_selected";

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-success']")
	private WebElement addGroupButton;
	@FindBy(how = How.XPATH, using = "//table[@id='result_list']")
	private WebElement groupTable;
	@FindBy(how = How.XPATH, using = "//input[@id='searchbar']")
	private WebElement searchInput;
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'search-container')]//input[@type='submit']")
	private WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//select[@name='action']")
	private WebElement groupActionSelect;
	@FindBy(how = How.XPATH, using = "//button[@name='index']")
	private WebElement doActionButton;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @id='action-toggle']")
	private WebElement chooseAllCheckbox;

	public GroupListPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Открыть страницу добавления новой группы.
	 */
	public AddGroupPage openAddGroupPage() {
		addGroupButton.click();
		return new AddGroupPage(driver);
	}

	/**
	 * Нажать на чекбокс для выбора всех записей в таблице.
	 */
	public void chooseAll() {
		if (!isChooseAllChecked()) {
			chooseAllCheckbox.click();
		}
	}

	/**
	 * Найти группу.
	 */
	public void searchGroup(String groupName) {
		setSearchInput(groupName);
		searchButton.click();
	}

	/**
	 * Удалить группу.
	 */
	public DeleteGroupPage deleteGroup(String groupName) {
		searchGroup(groupName);
		doAction(DELETE_ACTION);
		return new DeleteGroupPage(driver);
	}

	/**
	 * Проверка, что чекбокс активен.
	 */
	public boolean isChooseAllChecked() {
		return chooseAllCheckbox.isSelected();
	}

	/**
	 * Проверка наличия таблицы с группами на странице.
	 */
	public boolean isGroupExist() {
		return isVisible(groupTable);
	}

	/**
	 * Заполнить поле поиска группы.
	 */
	public void setSearchInput(String groupName) {
		setInputValue(searchInput, groupName);
	}

	private void doAction(String action) {
		chooseAll();
		groupActionSelect.click();
		driver.findElement(By.xpath(String.format(GROUP_OPTION_XPATH, action))).click();
		doActionButton.click();
	}
}
