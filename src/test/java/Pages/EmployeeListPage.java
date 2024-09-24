package Pages;
import loggerUtility.LoggerUtility;
import objectData.AddEmployeeObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class EmployeeListPage extends BasePage {
    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item'][text()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input[@placeholder='Type for hints...']")
    private List<WebElement> employeeNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
    private WebElement tableEntries;

    public void clickEmployeeListTab() {
        elementMethods.clickElement(employeeListTab);
        LoggerUtility.info("User clicks 'Employee List' tab.");
    }

    public void searchEmployee(AddEmployeeObject testData) {
        employeeNameField.get(0).sendKeys(testData.getEmployeeFullName());
        LoggerUtility.info("User searches employee name: "+ testData.getEmployeeFullName());
        elementMethods.clickElement(searchButton);
        LoggerUtility.info("User clicks search button.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateEmployeeEntry(AddEmployeeObject testData){
        String actualEntries = tableEntries.getText();
        Assert.assertTrue(actualEntries.contains(testData.getEmployeeFirstname()));
        LoggerUtility.info("Validation that employee's first name is: "+ testData.getEmployeeFirstname());
        Assert.assertTrue(actualEntries.contains(testData.getEmployeeLastname()));
        LoggerUtility.info("Validation that employee's last name is: " + testData.getEmployeeLastname());
       // Assert.assertTrue(actualEntries.contains("Automaton Tester"));
       // LoggerUtility.info("Validation that employee's job title is 'Automation Tester'");
    }
}

