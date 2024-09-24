package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PIMPage extends BasePage {
    public PIMPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-item'][text()='Add Employee']")
    private WebElement addEmployeeTab;


    public void addEmployeeTab(){
        elementMethods.clickElement(addEmployeeTab);
        LoggerUtility.info("User clicks on 'Add Employee' tab.");
    }








}
