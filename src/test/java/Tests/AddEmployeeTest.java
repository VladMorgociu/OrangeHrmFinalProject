package Tests;
import SharedData.SharedData;
import objectData.AddEmployeeObject;
import Pages.*;
import org.testng.annotations.Test;


public class AddEmployeeTest extends SharedData {

    @Test
    public  void testMethod() {


        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.enterCredentials();

        MenuItems menuItems = new MenuItems(getDriver());
        menuItems.clickPIM();

        PIMPage pimPage =new PIMPage(getDriver());
        pimPage.addEmployeeTab();

        AddEmployeeObject testData = new AddEmployeeObject("src/test/resources/TestData/AddEmployeeTestData.json");

        AddEmployeePage addEmployeePage = new AddEmployeePage(getDriver());
        addEmployeePage.addNewEmployee(testData);
        addEmployeePage.validateSuccessMessage(testData);

//        JobDetailsPage jobDetailsPage = new JobDetailsPage(getDriver());
//        jobDetailsPage.clickJobTab();
//        jobDetailsPage.chooseJobTitle();
//        jobDetailsPage.saveChanges();

        EmployeeListPage employeeListPage = new EmployeeListPage(getDriver());
        employeeListPage.clickEmployeeListTab();
        employeeListPage.searchEmployee(testData);
        employeeListPage.validateEmployeeEntry(testData);
    }
}
