package Pages;

import loggerUtility.LoggerUtility;
import objectData.NegativeLogInObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver){
        super(driver);
    }
    //find all elements from LogInPage

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']" )
    private WebElement loginButton;

    @FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']")
    private WebElement alertMessage;

    public void enterCredentials(){
        elementMethods.fillElement(usernameField, "Admin");
        LoggerUtility.info("User enters username: Admin");
        elementMethods.fillElement(passwordField, "admin123");
        LoggerUtility.info("User enters password: admin123");
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("User clicks login button");
    }

    public void enterWrongCredentials(NegativeLogInObject testData){
        elementMethods.fillElement(usernameField, testData.getUsernameValue());
        LoggerUtility.info("User enters wrong login username: "+ testData.getUsernameValue());
        elementMethods.fillElement(passwordField, testData.getPasswordValue());
        LoggerUtility.info("User enters wrong login password "+ testData.getPasswordValue());
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("User clicks on login button.");
    }
    public void validateAlertMessage(NegativeLogInObject testData ){
        String actualAlertMessage = alertMessage.getText();
        Assert.assertTrue(actualAlertMessage.contains(testData.getExpectedAlertMessage()));
        LoggerUtility.info("Validating that user gets message: "+testData.getExpectedAlertMessage());
    }

}
