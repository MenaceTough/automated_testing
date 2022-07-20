package selenium.test;

import org.junit.jupiter.api.Test;
import selenium.page.group.AddGroupPage;
import selenium.page.group.DeleteGroupPage;
import selenium.page.group.GroupListPage;
import selenium.page.HomePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupTest extends BaseTest {

	private static final String AUTH_URL = "https://djangosuit.com/admin/auth/";
	private static final String GROUP_LIST_PAGE_URL = "https://djangosuit.com/admin/auth/group";
	private static final String SEARCH_GROUP_ERROR = "Созданная группа не найдена";
	private static final String DELETE_GROUP_ERROR = "Созданная группа не удалена";
	private static final String LOGIN = "demo";
	private static final String PASSWORD = "demo";

	/**
	 * Тест добавления группы.
	 */
	@Test
	public void groupAddedAndRemoved() {
		String groupName = generateGroupName();
		driver.get(AUTH_URL);

		HomePage homePage = new HomePage(driver);
		homePage.setLogin(LOGIN)
				.setPassword(PASSWORD)
				.auth();

		addGroup(groupName);
		deleteGroup(groupName);
	}

	private void addGroup(String groupName) {
		driver.get(GROUP_LIST_PAGE_URL);
		GroupListPage groupListPage = new GroupListPage(driver);
		AddGroupPage addGroupPage = groupListPage.openAddGroupPage();
		groupListPage = addGroupPage.addGroup(groupName);
		groupListPage.searchGroup(groupName);
		assertTrue(groupListPage.isGroupExist(), SEARCH_GROUP_ERROR);
	}

	private void deleteGroup(String groupName) {
		driver.get(GROUP_LIST_PAGE_URL);
		GroupListPage groupListPage = new GroupListPage(driver);
		DeleteGroupPage deleteGroupPage = groupListPage.deleteGroup(groupName);
		groupListPage = deleteGroupPage.confirmDelete();
		groupListPage.searchGroup(groupName);
		assertFalse(groupListPage.isGroupExist(), DELETE_GROUP_ERROR);
	}

	private String generateGroupName() {
		return "group_" + (int) (Math.random() * 588000 + 1);
	}
}
