package Pages;

import loggerUtility.LoggerUtility;
import objectData.AddEmployeeObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class AddEmployeePage extends BasePage {
    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;
    @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement employeeID;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    private WebElement loginDetailsButton;
    @FindBy(xpath="//input[@class='oxd-input oxd-input--active'][@autocomplete='off']")
    private List<WebElement> logInDetails;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement saveButton;
    @FindBy(id = "oxd-toaster_1")
    private WebElement successMessage;

    public void addNewEmployee(AddEmployeeObject testData){
        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        LoggerUtility.info("User fills first name: " + testData.getFirstNameValue());
        elementMethods.fillElement(lastName, testData.getLastNameValue());
        LoggerUtility.info("User fills last name: " + testData.getLastNameValue());
        elementMethods.fillElement(employeeID, testData.getIdValue());
        LoggerUtility.info("User modifies employeeID value and adds + " + testData.getIdValue());
        elementMethods.clickElement(saveButton);
        LoggerUtility.info("User clicks save button");

    }
      public void validateSuccessMessage(AddEmployeeObject testData){
        elementMethods.waitVisibleElement(successMessage);
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(testData.getExpectedMessage()));
        LoggerUtility.info("Validating that success message contains: '" + testData.getExpectedMessage() + "'");
    }
}
