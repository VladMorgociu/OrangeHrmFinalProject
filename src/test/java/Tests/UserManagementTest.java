package Tests;
import SharedData.SharedData;
import objectData.UserManagementObject;
import Pages.AdminPage;
import Pages.LogInPage;
import Pages.MenuItems;
import Pages.UserManagementPage;
import org.testng.annotations.Test;

public class UserManagementTest extends SharedData {


    @Test
    public void testMethod() {

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.enterCredentials();

        MenuItems menuItems = new MenuItems(getDriver());
        menuItems.clickAdmin();

        AdminPage adminPage= new AdminPage(getDriver());
        adminPage.clickAddButton();

        UserManagementObject testData = new UserManagementObject("src/test/resources/TestData/UserManagementTestData.json");

        UserManagementPage userManagementPage= new UserManagementPage(getDriver());
        userManagementPage.makeAdminEmployee();
        userManagementPage.fillEmployeeDetails(testData);
        userManagementPage.clickSave();
        userManagementPage.validateSuccessMessage(testData);
    }
}
