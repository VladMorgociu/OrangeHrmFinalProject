package Pages;
import loggerUtility.LoggerUtility;
import objectData.UserManagementObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class UserManagementPage extends BasePage{
    public UserManagementPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
    private List<WebElement> userRoleField;
    @FindBy(xpath="//div[@role='option']//span[text()='Admin']")
    private WebElement userRoleAdminValue;
    @FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
    private List<WebElement> userStatusField;
    @FindBy(xpath="//span[text()='Enabled']")
    private WebElement userStatusEnabledValue;
    @FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input")
    private WebElement employeeNameField;
    @FindBy(xpath="//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div[@class='oxd-autocomplete-option']/span[text()='John  Doe']")
    private WebElement employeeNameSuggesstions;
    @FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
    private List<WebElement> usernameField;
    @FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div//input[@type='password']")
    private WebElement passwordField;
    @FindBy (xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div//input[@type='password']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(id="oxd-toaster_1")
    private WebElement successMessage;

    public void selectUserRoleField(){
        elementMethods.clickElementInList(userRoleField,0);
        LoggerUtility.info("User clicks 'Role' field.");
    }
    public void selectAdminUserRole(){
        elementMethods.clickElement(userRoleAdminValue);
        LoggerUtility.info("User selects 'Admin' role.");
    }
    public void selectStatusField(){
        elementMethods.clickElementInList(userStatusField, 1);
        LoggerUtility.info("User clicks 'Status' field.");
    }
    public void selectEnabledStatus(){
        elementMethods.clickElement(userStatusEnabledValue);
        LoggerUtility.info("User selects 'Enabled' status.");
    }
    public void searchEmployee(UserManagementObject testData){
//        elementMethods.clickElement(employeeNameField);
        elementMethods.fillElement(employeeNameField, testData.getEmployeeName());
        LoggerUtility.info("User fills 'Employee Name' field "+ testData.getEmployeeName() );
    }
    public void chooseEmployeeSuggestion(){
        elementMethods.clickElement(employeeNameSuggesstions);
        LoggerUtility.info("Chooses employee suggestion from list");
    }
    public void fillUsernameField(UserManagementObject testData){
        elementMethods.fillElementInList(usernameField, 1, testData.getUsernameValue()+System.currentTimeMillis());
        LoggerUtility.info("User fills 'Username' field " + testData.getUsernameValue()+System.currentTimeMillis());
    }
    public void fillPasswordField(UserManagementObject testData){
        elementMethods.fillElement(passwordField, testData.getPasswordValue());
        LoggerUtility.info("User fills 'Password' field " + testData.getPasswordValue());
    }
    public void fillConfirmPWField(UserManagementObject testData){
        elementMethods.fillElement(confirmPasswordField, testData.getConfirmPWValue());
        LoggerUtility.info("User fills 'Confirm password' field " + testData.getConfirmPWValue());
    }
    public void clickSave(){
        elementMethods.clickElement(submitButton);
        LoggerUtility.info("Chooses clicks 'Submit' button");
    }
    public void validateSuccessMessage( UserManagementObject testData){
        elementMethods.waitVisibleElement(successMessage);
        String actualMessage= successMessage.getText();
        Assert.assertTrue(actualMessage.contains(testData.getExpectedMessage()));
        LoggerUtility.info("Validationg that success message contains: "+testData.getExpectedMessage());
    }

    public void makeAdminEmployee(){
        selectUserRoleField();
        selectAdminUserRole();
        selectStatusField();
        selectEnabledStatus();
    }
    public void fillEmployeeDetails(UserManagementObject testData){
        searchEmployee(testData);
        chooseEmployeeSuggestion();
        fillUsernameField(testData);
        fillPasswordField(testData);
        fillConfirmPWField(testData);

    }

}
